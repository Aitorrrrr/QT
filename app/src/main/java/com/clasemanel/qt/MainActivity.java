package com.clasemanel.qt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button entrar;
    private Button registrar;
    private ArrayList<Usuario> users;
    private EditText inputUser;
    private EditText inputPw;

    private static int REQUEST = 1;
    private static String TAG="CSS";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<Usuario>();

        inputUser = (EditText) this.findViewById(R.id.inputUser);
        inputPw = (EditText) this.findViewById(R.id.inputPw);

        registrar = (Button) this.findViewById(R.id.registrar);
        registrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(getApplicationContext(),SignUp.class);

                startActivityForResult(i, REQUEST);
            }
        });

        entrar = (Button) this.findViewById(R.id.entrar);
        entrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                boolean correcto=false;
                for (Usuario aux: users)
                {
                    if (aux.getEmail().equals(inputUser.getText().toString()))
                    {
                        if (aux.getPassword().compareTo(inputPw.getText().toString())==0)
                        {
                            correcto=true;
                        }
                        else
                        {
                            Log.d(TAG,aux.getPassword()+" "+inputPw.getText().toString());
                        }
                    }
                    else
                    {
                        Log.d(TAG,aux.getEmail()+" "+inputUser.getText().toString());
                    }
                }

                if (correcto)
                {
                    Intent i = new Intent(getApplicationContext(),fin.class);

                    startActivity(i);
                }
            }
        });

        Usuario manel = new Usuario(1, "Manel", "Viel", "mviel@florida-uni.es", 654321098, "1234", true);
        users.add(manel);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1)
        {
            if (resultCode == RESULT_OK)
            {
                Usuario aux = (Usuario) data.getExtras().getParcelable("user");
                Log.d("CSS",aux.getID()+" "+aux.getNombre()+" "+aux.getApellido()+" "+aux.getTelefono()+" "+aux.getEmail()+" "+aux.getPassword());
                users.add(aux);
            }
            else
            {
                Log.d(TAG,"Resultado no válido");
            }
        }
        else
        {
            Log.d(TAG,"Request no válido");
        }
    }
}
