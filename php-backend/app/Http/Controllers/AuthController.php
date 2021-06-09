<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Crypt;
use Illuminate\Support\Facades\DB;

class AuthController extends Controller
{
  public function authenticate(Request $request)
  {
    $this->validate($request, [
      'email' => 'required',
      'pw' => 'required',
    ]);

    $email = $request->input("email");
    $pw = $request->input("pw");

    $user = DB::table('users')->select(['prename', 'lastname', 'pw', 'apiKey'])->where('email', '=', $email)->get()->first();

    if($pw == Crypt::decrypt($user->pw))
    {
      return response()->json([$user->apiKey, $user->prename, $user->lastname]);
    }

    return response()->json('Unauthorized', 401);
  }

}
