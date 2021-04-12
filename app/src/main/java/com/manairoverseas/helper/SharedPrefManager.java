package com.manairoverseas.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.manairoverseas.R;
import com.manairoverseas.fragments.CandidateLoginFragment;

public class SharedPrefManager {
    private Context context;
    private SharedPreferences sharedPreferences;

    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(context.getString(R.string.Pref_file_key),Context.MODE_PRIVATE);
    }
    public boolean IsUserLogin() {
        return sharedPreferences.getBoolean(context.getString(R.string.Pref_is_user_login), false);
    }
    public void UpdateUserLoginStatus(boolean status)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean(context.getString(R.string.Pref_is_user_login),status);
        editor.apply();
    }
    public void SaveUserName(String name)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.Pref_user_name),name);
        editor.apply();
    }
    public void SaveUserID(String Id)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.Pref_user_id),Id);
        editor.apply();
    }
    public void SaveCandidateID(String Id)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(context.getString(R.string.Pref_candidate_id),Id);
        editor.apply();
    }
    public String getUserName(){
        return sharedPreferences.getString(context.getString(R.string.Pref_user_name),null);

    }
    public String getUserId(){
        return sharedPreferences.getString(context.getString(R.string.Pref_user_id),null);

    }public String getCandidateId(){
        return sharedPreferences.getString(context.getString(R.string.Pref_candidate_id),null);

    }

}
   
