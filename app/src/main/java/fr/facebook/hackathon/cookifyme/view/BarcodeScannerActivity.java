package fr.facebook.hackathon.cookifyme.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture;
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import fr.facebook.hackathon.cookifyme.R;
import fr.facebook.hackathon.cookifyme.api.BarcodeLookupApi;
import info.androidhive.barcode.BarcodeReader;
import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever;

public class BarcodeScannerActivity extends AppCompatActivity implements BarcodeRetriever {
    BarcodeCapture barcodeCapture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);

        barcodeCapture = (BarcodeCapture) getSupportFragmentManager().findFragmentById(R.id.barcode_fragment);
        barcodeCapture.setRetrieval(this);
    }

    @Override
    public void onRetrieved(Barcode barcode) {
        barcodeCapture.stopScanning();
        BarcodeLookupApi.getApi(this).requestIngredient(barcode.displayValue);
        Toast.makeText(this, barcode.displayValue, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRetrievedMultiple(Barcode barcode, List<BarcodeGraphic> list) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onRetrievedFailed(String s) {

    }

    @Override
    public void onPermissionRequestDenied() {

    }
}
