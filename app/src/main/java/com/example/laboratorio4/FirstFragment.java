package com.example.laboratorio4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.laboratorio4.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private RadioButton num1;
    private RadioButton num2;
    private RadioButton num3;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.btnLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = obtenerNumero();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(phone));
                startActivity(intent);
            }

            private String obtenerNumero() {
                String numeroCel = "tel:";

                num1 = view.findViewById(R.id.rbtnTEL1);
                num2 = view.findViewById(R.id.rbtnTEL2);
                num3 = view.findViewById(R.id.rbtnTEL3);

                if(num1.isChecked()){
                    numeroCel = numeroCel + "49595616635";
                }else if(num1.isChecked()){
                    numeroCel = numeroCel + "4959567228";
                }else if(num1.isChecked()){
                    numeroCel = numeroCel + "4493206501";
                }

                return  numeroCel;
            }

        });


    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}