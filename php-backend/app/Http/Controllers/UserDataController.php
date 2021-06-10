<?php

namespace App\Http\Controllers;

use App\Events\NewCustomerHasRegisteredEvent;
use App\Helper\Util;
use App\Models\User;
use Illuminate\Http\Request;
use Illuminate\Support\Carbon;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Crypt;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;

class UserDataController extends Controller
{
  public function index(Request $request)
  {
    $token = $request->input('token');
    $filterDescription = $request->input('filterText');
    $filterAmountStart = $request->input('filterAmountStart');
    $filterAmountEnd = $request->input('filterAmountEnd');
    $filterTags = $request->input('filterTags');
    $userid = DB::table('users')->select(['id'])->where('apiKey', '=', $token)->get()->first()->id;
    $results = DB::table('userdata')->where('userid', '=', $userid);

    if($filterAmountStart != "" || $filterAmountEnd != "")
    {
      $results->where([
        ['amount', '>=', $filterAmountStart != "" ? intval($filterAmountStart) : PHP_INT_MIN],
        ['amount', '<=', $filterAmountEnd != "" ? intval($filterAmountEnd) : PHP_INT_MAX],
      ]);
    }

    $userdata = $results->get();

    // filter after getting collection
    if($filterTags != "")
    {
      $filterTagsExploded = explode(",", $filterTags); // get single filters
      $indicesToDelete = [];

      for($i = 0; $i < count($userdata); $i++)
      {
        $tagFoundCounter = 0; 

        foreach($filterTagsExploded as $filter)
        {
          // due to multiple filters possible, remove element only when no tag was found
          if(strpos($userdata[$i]->tags, $filter) === false)
          {
            $tagFoundCounter++;
          }

          if($tagFoundCounter == count($filterTagsExploded))
          {
            array_push($indicesToDelete, $i);
          }
        }
      }

      foreach($indicesToDelete as $index)
      {
        $userdata->pull($index);
      }
    } 

    // find text in description
    // get indices with key()
    if($filterDescription != "")
    {
      $userdataArray = $userdata->toArray();
      while ($element = current($userdataArray)) 
      {
        if(strpos(strtolower($element->description), strtolower($filterDescription)) === false)
        {
          $userdata->pull(key($userdataArray));
        }
        next($userdataArray);
      }
    }

    // reorder for new indices
    // due to collection no array_values is possible...
    $userdata_temp = [];
    foreach($userdata as $entry)
    {
      array_push($userdata_temp, $entry);
    }
    $userdata = $userdata_temp;

    return response()->json($userdata);
  }

  public function create(Request $request)
  {
  /*
    $this->validate($request, [
      'prename' => 'required',
      'lastname' => 'required',
      'email' => 'required',
      'pw' => 'required'
    ]);
    */

    $date_german_format = $request->input('date');
    $date = explode('.', $date_german_format);
    $date_formatted = $date[2].'-'.$date[1].'-'.$date[0];
    
    $amount = $request->input('amount');

    if($request->input('type') == 'expense')
    {
      $amount *= -1;
    }

    DB::insert('insert into userdata (type, userid, amount, date, account, category, description, tags, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
      [
        $request->input('type'),
        DB::table('users')->select(['id'])->where('apiKey', '=', $request->input('token'))->get()->first()->id,
        $amount,
        $date_formatted,
        $request->input('account'),
        $request->input('category'),
        $request->input('description'),
        $request->input('tags'),
        Carbon::now(),
        Carbon::now()
      ]
    );

    return response()->json('success', 201); // normally return created resource
  }

}
