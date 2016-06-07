package com.example.phil.noteapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Phil on 07.06.2016.
 */
public class NoteListFragment extends Fragment {

    //NOTE: you had to add a dependency and a layout file to support the RecyclerView
    private RecyclerView mNoteRecyclerView;
    private NoteAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        //NOTE: RecyclerView recycles views and positions them on the screen by using a
        // LayoutManager. LayoutManager defines positioning and Scrolling behavior. There are third
        // party LayoutManagers!
        mNoteRecyclerView = (RecyclerView) view
                .findViewById(R.id.note_recycler_view);
        mNoteRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    //NOTE: creating adapter and setting it in the RecyclerView
    private void updateUI() {
        NoteSingleton noteSingleton = NoteSingleton.get(getActivity());
        List<Note> notes = noteSingleton.getNotes();

        mAdapter = new NoteAdapter(notes);
        mNoteRecyclerView.setAdapter(mAdapter);
    }

    //NOTE: is managed by a RecyclerView and holds a single view, for example a
    // TextView, but doesn't have to be so static
    private class NoteHolder extends RecyclerView.ViewHolder {
        public TextView mTitleTextView;

        public NoteHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
    }

    //NOTE: RecyclerView will communicate with this adapter when ViewHolder needs to be created or
    // connected with a Note object
    private class NoteAdapter extends RecyclerView.Adapter<NoteHolder> {
        private List<Note> mNotes;

        public NoteAdapter(List<Note> notes) {
            mNotes = notes;
        }

        @Override
        public NoteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(android.R.layout.simple_list_item_1, parent, false);
            return new NoteHolder(view);
        }

        @Override
        public void onBindViewHolder(NoteHolder holder, int position) {
            Note note = mNotes.get(position);
            holder.mTitleTextView.setText(note.getTitle());
        }

        @Override
        public int getItemCount() {
            return mNotes.size();
        }
    }
}
