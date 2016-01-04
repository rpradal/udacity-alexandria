package it.jaschke.alexandria.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by RPR on 04/01/16.
 */
public class CameraScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    // ---------------------------------
    // CONSTANTS
    // ---------------------------------

    public static final int REQUEST_CODE = 1001;

    // ---------------------------------
    // ATTRIBUTES
    // ---------------------------------

    private ZXingScannerView mZXingScannerView;

    // ---------------------------------
    // LIFECYCLE
    // ---------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mZXingScannerView = new ZXingScannerView(this);
        setContentView(mZXingScannerView);
    }

    @Override
    public void onResume() {
        super.onResume();
        mZXingScannerView.setResultHandler(this);
        mZXingScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mZXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Intent intent = new Intent();
        intent.putExtra("EAN", result.getText());
        setResult(REQUEST_CODE, intent);
        finish();
    }

}
