/**
 * Frank Berrocal Azofeifa
 * Final Project
 *
 * SODV3203 Mobile Application Development
 * Prof.  Ali Moussa
 * Bow Valley College
 *
 * April 2023
 */

package com.example.finalproject_fberrocal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;


import org.json.JSONException;

import java.math.BigDecimal;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_payment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_payment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    Button button_open;
    EditText input_amount;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static final String clientID = "ARYJqdiXXO0QElPgN5yqKDNAjUc1iVOolkR8JbL5QMwJ2WTpmcmqjUjGyJeke1stzpvLPW9FfkA0QAMe";
    public static final int PAYPAL_REQUEST_CODE = 123;
    public static PayPalConfiguration configuration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(clientID);

    public fragment_payment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_payment.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_payment newInstance(String param1, String param2) {
        fragment_payment fragment = new fragment_payment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * onCreate
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     * Association of views.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    /**
     * onCreateView
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * association of elements
     * @return view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //I am creating a reference to the inflater to be able to work with the objects in the layout.
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        button_open = view.findViewById(R.id.button_open);
        input_amount = view.findViewById(R.id.input_amount);

        button_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPaypal();
            }
        });

        return view;
    }

    /**
     * showPaypal
     * input captured and validated.  Input is converted to BigDecimal, indicating the currency and name of the App for
     * registration purposes, then, Payment intent sale is indicated using the Paypal package.
     */
    public void showPaypal() {
        String amount =  input_amount.getText().toString();
        if(amount.equals("")) {
            Toast.makeText(requireContext(), "Please enter any amount", Toast.LENGTH_SHORT).show();

        }else {
            PayPalPayment payment = new PayPalPayment(new BigDecimal(String.valueOf(amount)), "USD", "Tempo", PayPalPayment.PAYMENT_INTENT_SALE);

            Intent intent = new Intent(getActivity(), PaymentActivity.class);
            intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, configuration);
            intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
            startActivityForResult(intent, PAYPAL_REQUEST_CODE);
        }

    }

    /**
     * onActivityResult (deprecated)
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     * if response is received confirming request code, the config is updated with the data from the confirmation.
     *             Several error scenarios are considered.
     *             PayPal is displayed in a browser for processing, providing security to the user.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==PAYPAL_REQUEST_CODE){
            PayPalConfiguration config = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
            if(config!=null) {
                String paymentDetails = config.toString();
            }
        }else if(requestCode== Activity.RESULT_CANCELED){
            System.out.println("Error in transaction");
        }else if (requestCode==PaymentActivity.RESULT_EXTRAS_INVALID){
            System.out.println("Payment rejected");
        }
    }
}

/**
 * References
 *
 * The reference was totally needed to complete this, since the API material is dense, not poiting to something as simple as the code in the source, and completely out of the boundaries of the contents of the course.
 * Learn with Arvind.  (November, 2022).  How to Integrate PayPal in Android Studio 2023 | Paypal SDK Intergration.  (YouTube).   Retrieved on April 10th, 2023, from https://www.youtube.com/watch?v=CGfkcdn9APE
 */