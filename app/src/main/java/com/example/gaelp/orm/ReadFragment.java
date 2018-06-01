package com.example.gaelp.orm;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReadFragment extends ListFragment {
    static List<Contact> contacts;
    SimpleAdapter adapter;
    ArrayList<HashMap<String, String>> data;


    public ReadFragment() { }

    public static ReadFragment newInstance(List<Contact> contacts) {
        ReadFragment leFragment = new ReadFragment();
        ReadFragment.contacts = contacts;
        return leFragment;
    }

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        data = new ArrayList<>();

        adapter = new SimpleAdapter(getContext(),
                data,
                R.layout.contact,
                new String[] {"id", "name", "firstname"},
                new int[] {R.id.read_id, R.id.read_name, R.id.read_firstname});

        setListAdapter(adapter);
        updateSource(contacts);

        if (getActivity() instanceof OnItemSelectedListener) listener = (OnItemSelectedListener) getActivity();
        else
            throw new ClassCastException(getActivity().toString()
                    + " must implement listFragment.OnItemSelectedListener");

        return super.onCreateView( inflater, container, savedInstanceState);
    }

    public void updateSource(List<Contact> lesContacts){
        this.contacts = lesContacts;
        data.clear();

        if(contacts.size() !=0) {
            Iterator contactIterator = contacts.iterator();
            while(contactIterator.hasNext()){
                Contact leContact = (Contact)contactIterator.next();
                addItem(leContact);
            }

        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        super.onListItemClick(l, v, position, id);
        TextView idb = (TextView)v.findViewById(R.id.read_id);
        updateDetail(idb.getText().toString());
    }

    public interface OnItemSelectedListener {
        void onRssItemSelected(String id);
    }
    private OnItemSelectedListener listener;

    public void updateDetail(String id) {
        listener.onRssItemSelected(id);
    }

    public void addItem(Contact leContact) {
        HashMap<String, String> item = new HashMap<String, String>();
        item.put("id", leContact.getId()+"");
        item.put("name", leContact.getName());
        item.put("firstname", leContact.getFirstname());
        data.add(item);
    }

}
