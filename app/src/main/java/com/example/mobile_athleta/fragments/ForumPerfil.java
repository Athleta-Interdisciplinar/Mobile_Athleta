package com.example.mobile_athleta.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobile_athleta.R;
import com.example.mobile_athleta.adapter.ForumAdapter;
import com.example.mobile_athleta.adapter.PostAdapter;
import com.example.mobile_athleta.models.Forum;
import com.example.mobile_athleta.models.Post;

import java.util.ArrayList;
import java.util.List;

public class ForumPerfil extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ForumPerfil() {
    }

    public static ForumPerfil newInstance(String param1, String param2) {
        ForumPerfil fragment = new ForumPerfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private ForumAdapter forumAdapter;
    private List<Forum> forumList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forum_perfil, container, false);

        RecyclerView recyclerViewForum = view.findViewById(R.id.recycler_forum_perfil);

        forumList = new ArrayList<>();

        forumList.add(new Forum(1, "PingPros", "Comunidade de ping pong.", "user2", "https://i.scdn.co/image/ab6761610000e5eb0522e98a6f0cf1ddbee9a74f", "https://lastfm.freetls.fastly.net/i/u/ar0/bed47046a143ce2bb4d2fcb3530dacc9.jpg", 0));
        forumList.add(new Forum(2, "PingPros", "Comunidade de ping pong.", "user2", "https://lastfm.freetls.fastly.net/i/u/ar0/bed47046a143ce2bb4d2fcb3530dacc9.jpg", "https://lastfm.freetls.fastly.net/i/u/avatar170s/41049b383497d46303be8310be34fd96", 0));
        forumList.add(new Forum(3, "PingPros", "Comunidade de ping pong.", "user2", "https://lastfm.freetls.fastly.net/i/u/ar0/bed47046a143ce2bb4d2fcb3530dacc9.jpg", "https://lastfm.freetls.fastly.net/i/u/ar0/bed47046a143ce2bb4d2fcb3530dacc9.jpg", 0));

        recyclerViewForum.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        forumAdapter = new ForumAdapter(forumList);
        recyclerViewForum.setAdapter(forumAdapter);

        return view;
    }
}