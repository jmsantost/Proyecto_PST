// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityModoManualBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button aceptar;

  @NonNull
  public final EditText et1;

  @NonNull
  public final EditText et2;

  @NonNull
  public final TextView temperaturaGrados;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView6;

  @NonNull
  public final Button volver;

  private ActivityModoManualBinding(@NonNull ConstraintLayout rootView, @NonNull Button aceptar,
      @NonNull EditText et1, @NonNull EditText et2, @NonNull TextView temperaturaGrados,
      @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5,
      @NonNull TextView textView6, @NonNull Button volver) {
    this.rootView = rootView;
    this.aceptar = aceptar;
    this.et1 = et1;
    this.et2 = et2;
    this.temperaturaGrados = temperaturaGrados;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
    this.textView6 = textView6;
    this.volver = volver;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityModoManualBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityModoManualBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_modo_manual, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityModoManualBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aceptar;
      Button aceptar = ViewBindings.findChildViewById(rootView, id);
      if (aceptar == null) {
        break missingId;
      }

      id = R.id.et1;
      EditText et1 = ViewBindings.findChildViewById(rootView, id);
      if (et1 == null) {
        break missingId;
      }

      id = R.id.et2;
      EditText et2 = ViewBindings.findChildViewById(rootView, id);
      if (et2 == null) {
        break missingId;
      }

      id = R.id.temperaturaGrados;
      TextView temperaturaGrados = ViewBindings.findChildViewById(rootView, id);
      if (temperaturaGrados == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView6;
      TextView textView6 = ViewBindings.findChildViewById(rootView, id);
      if (textView6 == null) {
        break missingId;
      }

      id = R.id.volver;
      Button volver = ViewBindings.findChildViewById(rootView, id);
      if (volver == null) {
        break missingId;
      }

      return new ActivityModoManualBinding((ConstraintLayout) rootView, aceptar, et1, et2,
          temperaturaGrados, textView3, textView4, textView5, textView6, volver);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
