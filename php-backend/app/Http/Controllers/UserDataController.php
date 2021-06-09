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
    $userid = DB::table('users')->select(['id'])->where('apiKey', '=', $token)->get()->first()->id;
    $userdata = DB::table('userdata')->where('userid', '=', $userid)->get();
    
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

    DB::insert('insert into userdata (type, userid, amount, date, account, category, description, tags, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)',
      [
        $request->input('type'),
        DB::table('users')->select(['id'])->where('apiKey', '=', $request->input('token'))->get()->first()->id,
        $request->input('amount'),
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
