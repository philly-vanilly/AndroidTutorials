package com.example.phil.noteapp;

import android.support.v4.app.Fragment;
import android.util.Log;

/**
 * Created by Phil on 07.06.2016.
 */
public class NoteListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Log.d("=============", "NoteListActivity.createFragement() called");

        return new NoteListFragment();
    }
}
