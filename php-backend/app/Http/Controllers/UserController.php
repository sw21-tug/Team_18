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

class UserController extends Controller
{
  public function index()
  {
    return response()->json(DB::table('users')->select(['prename', 'lastname', 'email', 'apiKey', 'created_at', 'updated_at'])->get());
  }

  public function create(Request $request)
  {
    $this->validate($request, [
      'prename' => 'required',
      'lastname' => 'required',
      'email' => 'required',
      'pw' => 'required'
    ]);

    DB::insert('insert into users (prename, lastname, email, pw, apiKey, created_at, updated_at) values (?, ?, ?, ?, ?, ?, ?)', 
      [
        $request->input('prename'),
        $request->input('lastname'),
        $request->input('email'),
        Crypt::encrypt($request->input('pw')),
        base64_encode(Str::random(40)),
        Carbon::now(),
        Carbon::now()
      ]
    );
    
    return response()->json('success', 201); // normally return created resource
  }

}
