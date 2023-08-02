// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

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
import com.example.foodyghar.R;
import com.google.android.material.textfield.TextInputLayout;
import com.henley.shadowlayout.ShadowLayout;
import in.aabhasjindal.otptextview.OtpTextView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityForgetPasswordBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText EdFpCon;

  @NonNull
  public final Button btngetotp;

  @NonNull
  public final Button btnverify;

  @NonNull
  public final ConstraintLayout mainContainer4;

  @NonNull
  public final OtpTextView otpView;

  @NonNull
  public final TextView rotp;

  @NonNull
  public final ShadowLayout shadowView;

  @NonNull
  public final TextInputLayout tilFpMob;

  private ActivityForgetPasswordBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText EdFpCon, @NonNull Button btngetotp, @NonNull Button btnverify,
      @NonNull ConstraintLayout mainContainer4, @NonNull OtpTextView otpView,
      @NonNull TextView rotp, @NonNull ShadowLayout shadowView, @NonNull TextInputLayout tilFpMob) {
    this.rootView = rootView;
    this.EdFpCon = EdFpCon;
    this.btngetotp = btngetotp;
    this.btnverify = btnverify;
    this.mainContainer4 = mainContainer4;
    this.otpView = otpView;
    this.rotp = rotp;
    this.shadowView = shadowView;
    this.tilFpMob = tilFpMob;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityForgetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityForgetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_forget_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityForgetPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.EdFp_Con;
      EditText EdFpCon = ViewBindings.findChildViewById(rootView, id);
      if (EdFpCon == null) {
        break missingId;
      }

      id = R.id.btngetotp;
      Button btngetotp = ViewBindings.findChildViewById(rootView, id);
      if (btngetotp == null) {
        break missingId;
      }

      id = R.id.btnverify;
      Button btnverify = ViewBindings.findChildViewById(rootView, id);
      if (btnverify == null) {
        break missingId;
      }

      ConstraintLayout mainContainer4 = (ConstraintLayout) rootView;

      id = R.id.otp_view;
      OtpTextView otpView = ViewBindings.findChildViewById(rootView, id);
      if (otpView == null) {
        break missingId;
      }

      id = R.id.rotp;
      TextView rotp = ViewBindings.findChildViewById(rootView, id);
      if (rotp == null) {
        break missingId;
      }

      id = R.id.shadow_view;
      ShadowLayout shadowView = ViewBindings.findChildViewById(rootView, id);
      if (shadowView == null) {
        break missingId;
      }

      id = R.id.til_FpMob;
      TextInputLayout tilFpMob = ViewBindings.findChildViewById(rootView, id);
      if (tilFpMob == null) {
        break missingId;
      }

      return new ActivityForgetPasswordBinding((ConstraintLayout) rootView, EdFpCon, btngetotp,
          btnverify, mainContainer4, otpView, rotp, shadowView, tilFpMob);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
