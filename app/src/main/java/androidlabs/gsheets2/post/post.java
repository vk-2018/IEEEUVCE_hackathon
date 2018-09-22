



//public class post extends AppCompatActivity {
//
//    EditText Email,Pass,father,mother,Optional;
//    Button b;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//
//        Email=(EditText)findViewById(R.id.etEmail);
//        Pass=(EditText)findViewById(R.id.etPass);
//        father=(EditText)findViewById(R.id.etfather);
//        mother=(EditText)findViewById(R.id.etmother);
//        Optional=(EditText)findViewById(R.id.etmother);
//        b=(Button)findViewById(R.id.btLogin);
//
//        Email.getText().toString();
//
//
//    }
//
//}

package androidlabs.gsheets2.post;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONObject;

        import java.io.BufferedReader;
        import java.io.BufferedWriter;
        import java.io.InputStreamReader;
        import java.io.OutputStream;
        import java.io.OutputStreamWriter;
        import java.net.HttpURLConnection;
        import java.net.URL;
        import java.net.URLEncoder;
        import java.util.Iterator;

        import javax.net.ssl.HttpsURLConnection;

        import androidlabs.gsheets2.Emergencyactivity;
        import androidlabs.gsheets2.R;

public class post extends AppCompatActivity {
    private ProgressDialog progress;


    TextView tvName;
    TextView tvphno;
    TextView tvemail;
    Button button;
    String name;
    String phno;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        button = (Button) findViewById(R.id.btn_submit);
        tvName = (EditText) findViewById(R.id.input_name);
        tvphno = (EditText) findViewById(R.id.input_phno);
        tvemail = (EditText) findViewById(R.id.input_email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = tvName.getText().toString();
                phno = tvphno.getText().toString();
                email = tvemail.getText().toString();

                new SendRequest().execute();
                Intent i= new Intent(post.this, Emergencyactivity.class);
               startActivity(i);
            }

        });

    }


    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute() {
        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://script.google.com/macros/s/AKfycbxLIAbDtJ8wxJoX7VtgoNa3hGvd_JaDXjdHk2oYJGypEdr3EDuk/exec");
                // https://script.google.com/macros/s/AKfycbyuAu6jWNYMiWt9X5yp63-hypxQPlg5JS8NimN6GEGmdKZcIFh0/exec
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String id = "1Brq8KjvnEVmdQ5yIP74HaCfgN89-mDRbtC_22DEnfYM";

                postDataParams.put("name", name);
                postDataParams.put("phno", phno);
                postDataParams.put("email", email);
                postDataParams.put("id", id);


                Log.e("params", postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line = "";

                    while ((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                } else {
                    return new String("false : " + responseCode);
                }
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

//        @Override
//        protected void onPostExecute(String result) {
//            Toast.makeText(getApplicationContext(), result,
//                    Toast.LENGTH_LONG).show();
//
//        }
//    }

        public String getPostDataString(JSONObject params) throws Exception {

            StringBuilder result = new StringBuilder();
            boolean first = true;

            Iterator<String> itr = params.keys();

            while (itr.hasNext()) {

                String key = itr.next();
                Object value = params.get(key);

                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(key, "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(value.toString(), "UTF-8"));

            }
            return result.toString();
        }
    }
}