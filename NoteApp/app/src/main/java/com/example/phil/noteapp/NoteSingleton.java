package com.example.phil.noteapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Phil on 06.06.2016.
 */
public class NoteSingleton {
    private static NoteSingleton sNoteSingleton;

    private List<Note> mNotes;

    private NoteSingleton(Context context) {
        mNotes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Note note = new Note();
            note.setTitle("Note #" + i);
            note.setFinished(i % 2 == 0); // Every other one
            mNotes.add(note);
        }
    }

    public static NoteSingleton get(Context context) {
        if (sNoteSingleton == null) {
            sNoteSingleton = new NoteSingleton(context);
        }
        return sNoteSingleton;
    }

    public List<Note> getNotes() {
        return mNotes;
    }

    public Note getNote(UUID id) {
        for (Note note : mNotes) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }
}
