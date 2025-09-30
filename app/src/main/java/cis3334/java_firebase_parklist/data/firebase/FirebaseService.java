package cis3334.java_firebase_parklist.data.firebase;

import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

import cis3334.java_firebase_parklist.data.model.Park;

public class FirebaseService {

    // TODO: Implement FirebaseService object

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    private void fetchParks() {
        db.collection("parks").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {task -> {
            if (task.isSuccessful()) {
                for (QueryDocumentSnapshot document : task.getResult()) {
                    Log.d("CIS3334", document.getId() + " => " + document.getData());
                    Park park = document.toObject(Park.class);
                    itemViewModel.addItem(park);
                    Log.d("CIS3334", document.getId() + " => " + document.getData());
                }
            } else {
                Log.w("CIS3334", "Error getting documents.", task.getException();
            }
        }
        }
    }