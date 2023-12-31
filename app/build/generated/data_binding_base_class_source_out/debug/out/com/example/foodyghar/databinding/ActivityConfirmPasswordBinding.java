// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import com.google.android.material.textfield.TextInputLayout;
import com.henley.shadowlayout.ShadowLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityConfirmPasswordBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final EditText EdCrfmPassword;

  @NonNull
  public final EditText EdNewPassword;

  @NonNull
  public final Button btncngpswd;

  @NonNull
  public final ScrollView mainContainer3;

  @NonNull
  public final ShadowLayout shadowView;

  @NonNull
  public final TextInputLayout tilCrfmPassword;

  @NonNull
  public final TextInputLayout tilNewPassword;

  private ActivityConfirmPasswordBinding(@NonNull ScrollView rootView,
      @NonNull EditText EdCrfmPassword, @NonNull EditText EdNewPassword, @NonNull Button btncngpswd,
      @NonNull ScrollView mainContainer3, @NonNull ShadowLayout shadowView,
      @NonNull TextInputLayout tilCrfmPassword, @NonNull TextInputLayout tilNewPassword) {
    this.rootView = rootView;
    this.EdCrfmPassword = EdCrfmPassword;
    this.EdNewPassword = EdNewPassword;
    this.btncngpswd = btncngpswd;
    this.mainContainer3 = mainContainer3;
    this.shadowView = shadowView;
    this.tilCrfmPassword = tilCrfmPassword;
    this.tilNewPassword = tilNewPassword;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityConfirmPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityConfirmPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_confirm_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityConfirmPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Ed_crfm_password;
      EditText EdCrfmPassword = ViewBindings.findChildViewById(rootView, id);
      if (EdCrfmPassword == null) {
        break missingId;
      }

      id = R.id.Ed_new_password;
      EditText EdNewPassword = ViewBindings.findChildViewById(rootView, id);
      if (EdNewPassword == null) {
        break missingId;
      }

      id = R.id.btncngpswd;
      Button btncngpswd = ViewBindings.findChildViewById(rootView, id);
      if (btncngpswd == null) {
        break missingId;
      }

      ScrollView mainContainer3 = (ScrollView) rootView;

      id = R.id.shadow_view;
      ShadowLayout shadowView = ViewBindings.findChildViewById(rootView, id);
      if (shadowView == null) {
        break missingId;
      }

      id = R.id.til_crfm_Password;
      TextInputLayout tilCrfmPassword = ViewBindings.findChildViewById(rootView, id);
      if (tilCrfmPassword == null) {
        break missingId;
      }

      id = R.id.til_new_password;
      TextInputLayout tilNewPassword = ViewBindings.findChildViewById(rootView, id);
      if (tilNewPassword == null) {
        break missingId;
      }

      return new ActivityConfirmPasswordBinding((ScrollView) rootView, EdCrfmPassword,
          EdNewPassword, btncngpswd, mainContainer3, shadowView, tilCrfmPassword, tilNewPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
