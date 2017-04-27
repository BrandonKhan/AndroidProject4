package com.wtmk.brandon.spritanimal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.wtmk.brandon.spritanimal.Model.SlectionData;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {

    public static final  String EXTRA_MESSAGE = "com.wtmk.brandon.spritanimal";
    private Spinner mDolphinSpinner;
    private Spinner mElephantSpinner;
    private Spinner mMonkeySpinner;
    private Spinner mRedpandaSpinner;
    private Spinner mLionSpinner;
    private ArrayAdapter<CharSequence> mSectionAdapter;
    private String[] mSectionArray = new String[5];
    private SlectionData mSlectionData = new SlectionData();
    private Button mSubmit;
    private TextView mTigerTextView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionAdapter = ArrayAdapter.createFromResource(this, R.array.likelyArray, android.R.layout.simple_spinner_item);

        mLionSpinner = (Spinner) findViewById(R.id.lionSpinner);
        mLionSpinner.setAdapter(mSectionAdapter);

        mDolphinSpinner = (Spinner) findViewById(R.id.dolphinSpinner);
        mDolphinSpinner.setAdapter(mSectionAdapter);

        mElephantSpinner = (Spinner) findViewById(R.id.elephantSpinner);
        mElephantSpinner.setAdapter(mSectionAdapter);

        mMonkeySpinner = (Spinner) findViewById(R.id.monkeySpinner);
        mMonkeySpinner.setAdapter(mSectionAdapter);

        mRedpandaSpinner =(Spinner) findViewById(R.id.redpandaSpinner);
        mRedpandaSpinner.setAdapter(mSectionAdapter);

        mSubmit = (Button) findViewById(R.id.submit);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getSpinnerValue(mLionSpinner);
                getSpinnerValue(mDolphinSpinner);
                getSpinnerValue(mElephantSpinner);
                getSpinnerValue(mMonkeySpinner);
                getSpinnerValue(mRedpandaSpinner);

                NavigableMap<Integer,String> spinnerValueList = new TreeMap<>();

                int tiger = mSlectionData.getTiger();
                int dolphin = mSlectionData.getDolphin();
                int elephant = mSlectionData.getElephant();
                int monkey = mSlectionData.getMonkey();
                int redpanda = mSlectionData.getRedpanda();


                spinnerValueList.put(tiger,"tiger");
                spinnerValueList.put(dolphin,"dolphin");
                spinnerValueList.put(elephant,"elephant");
                spinnerValueList.put(monkey,"monkey");
                spinnerValueList.put(redpanda,"redpanda");

                Map.Entry<Integer,String> lastEntry = spinnerValueList.lastEntry();
                String youAre = lastEntry.getValue();

                mTigerTextView.setText(youAre);

                Intent intent = new Intent(MainActivity.this,DisplayImage.class);
               intent.putExtra(EXTRA_MESSAGE,youAre);
               startActivity(intent);
            }
        });

        mTigerTextView = (TextView) findViewById(R.id.lionTextView);

    }

    private void getSpinnerValue(Spinner spinner){

        String slected = spinner.getSelectedItem().toString();

        switch (slected){

            case "Nope!":
                mSlectionData.setDolphin(1);
                break;
            case "Not likely...":
                mSlectionData.setTiger(1);
                break;
            case "..50/50..":
                mSlectionData.setElephant(1);
                break;
            case "Likely...":
                mSlectionData.setMonkey(1);
                break;
            case "Yes sounds like me!":
                mSlectionData.setRedpanda(1);
                break;


        }

    }
}
