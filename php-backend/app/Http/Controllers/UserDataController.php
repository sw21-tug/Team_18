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
  public function index()
  {
    return response()->json(DB::table('users')->select(['prename', 'lastname', 'email', 'apiKey', 'created_at', 'updated_at'])->get());
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

    DB::insert('insert into userdata (type, userid, amount, date, account, category, description, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?, ?, ?)',
      [
        $request->input('type'),
        0,
        $request->input('amount'),
        $date_formatted,
        $request->input('account'),
        $request->input('category'),
        $request->input('description'),
        Carbon::now(),
        Carbon::now()
      ]
    );

    return response()->json('success', 201); // normally return created resource
  }

}
