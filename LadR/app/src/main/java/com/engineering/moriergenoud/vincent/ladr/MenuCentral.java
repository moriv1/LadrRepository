package com.engineering.moriergenoud.vincent.ladr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MenuCentral extends AppCompatActivity {

    /*Variables Declaration*/

    private Button mStationConnexionButton;
    private Button mPersonalDataButton;
    private Button mActivationKeyButton;
    private TextView mDisplayKey;

    String TransfertFirstName;
    String TransfertLastName;
    String TransfertLicence;
    String TransfertCarModel;
    String TransfertClientNumber;
    String  ClientToStationActivationKey="000000000000000";
    String OrderedActivationKey= "165493527916548";

    /*onCreate void*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_central);

        /*link with layout*/

        mPersonalDataButton  = (Button) findViewById(R.id.activity_personalData_btn);
        mStationConnexionButton = (Button) findViewById(R.id.activity_stationConnexion_btn);
        mActivationKeyButton = (Button) findViewById(R.id.activity_activation_key_btn);
        mDisplayKey = (TextView) findViewById(R.id.activity_menuCentral_key_display_txt);

        /*Variables transfert*/

        TransfertFirstName=getIntent().getExtras().getString("FirstName");
        TransfertLastName=getIntent().getExtras().getString("LastName");
        TransfertLicence=getIntent().getExtras().getString("Licence");
        TransfertCarModel=getIntent().getExtras().getString("CarModel");
        TransfertClientNumber=getIntent().getExtras().getString("ClientNumber");

        /*Button to connect with Station Connection*/

        mStationConnexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User clicked the button

                // Inscription successful
                Intent stationConnexionIntent = new Intent(MenuCentral.this, StationConnexionActivity.class);
                stationConnexionIntent.putExtra("ClientNumber2",TransfertClientNumber);
                stationConnexionIntent.putExtra("ClientToStationActivationKey",ClientToStationActivationKey);
                startActivity(stationConnexionIntent);

            }
        });

        /*Button to connect with personal data activities*/

        mPersonalDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // User clicked the button
                Intent personalDataActivityIntent = new Intent (MenuCentral.this, PersonalDataActivity.class);
                personalDataActivityIntent.putExtra("FirstName2",TransfertFirstName);
                personalDataActivityIntent.putExtra("LastName2",TransfertLastName);
                personalDataActivityIntent.putExtra("Licence2",TransfertLicence);
                personalDataActivityIntent.putExtra("CarModel2",TransfertCarModel);
                personalDataActivityIntent.putExtra("ClientNumber2",TransfertClientNumber);
                startActivity(personalDataActivityIntent);
            }
        });

        /*Button to order an activation key*/

        mActivationKeyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Command an activation key*/

               ClientToStationActivationKey= OrderedActivationKey;

               Toast.makeText(getBaseContext(),"New activation key received", Toast.LENGTH_SHORT).show();

               mDisplayKey.setText("Key available: \n"+ClientToStationActivationKey);
            }
        });
    }
}

