// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
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

public final class ActivityRegistrationBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final Button btnsubmit;

  @NonNull
  public final EditText contact;

  @NonNull
  public final EditText email;

  @NonNull
  public final ScrollView mainContainer2;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView retlogin;

  @NonNull
  public final ShadowLayout shadowView;

  @NonNull
  public final TextInputLayout tilRegEmail;

  @NonNull
  public final TextInputLayout tilRegFName;

  @NonNull
  public final TextInputLayout tilRegLName;

  @NonNull
  public final TextInputLayout tilRegMob;

  @NonNull
  public final TextInputLayout tilRegPassword;

  @NonNull
  public final EditText txtfname;

  @NonNull
  public final EditText txtlname;

  private ActivityRegistrationBinding(@NonNull ScrollView rootView, @NonNull Button btnsubmit,
      @NonNull EditText contact, @NonNull EditText email, @NonNull ScrollView mainContainer2,
      @NonNull EditText password, @NonNull TextView retlogin, @NonNull ShadowLayout shadowView,
      @NonNull TextInputLayout tilRegEmail, @NonNull TextInputLayout tilRegFName,
      @NonNull TextInputLayout tilRegLName, @NonNull TextInputLayout tilRegMob,
      @NonNull TextInputLayout tilRegPassword, @NonNull EditText txtfname,
      @NonNull EditText txtlname) {
    this.rootView = rootView;
    this.btnsubmit = btnsubmit;
    this.contact = contact;
    this.email = email;
    this.mainContainer2 = mainContainer2;
    this.password = password;
    this.retlogin = retlogin;
    this.shadowView = shadowView;
    this.tilRegEmail = tilRegEmail;
    this.tilRegFName = tilRegFName;
    this.tilRegLName = tilRegLName;
    this.tilRegMob = tilRegMob;
    this.tilRegPassword = tilRegPassword;
    this.txtfname = txtfname;
    this.txtlname = txtlname;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegistrationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegistrationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_registration, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegistrationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnsubmit;
      Button btnsubmit = ViewBindings.findChildViewById(rootView, id);
      if (btnsubmit == null) {
        break missingId;
      }

      id = R.id.contact;
      EditText contact = ViewBindings.findChildViewById(rootView, id);
      if (contact == null) {
        break missingId;
      }

      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      ScrollView mainContainer2 = (ScrollView) rootView;

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.retlogin;
      TextView retlogin = ViewBindings.findChildViewById(rootView, id);
      if (retlogin == null) {
        break missingId;
      }

      id = R.id.shadow_view;
      ShadowLayout shadowView = ViewBindings.findChildViewById(rootView, id);
      if (shadowView == null) {
        break missingId;
      }

      id = R.id.til_RegEmail;
      TextInputLayout tilRegEmail = ViewBindings.findChildViewById(rootView, id);
      if (tilRegEmail == null) {
        break missingId;
      }

      id = R.id.til_RegFName;
      TextInputLayout tilRegFName = ViewBindings.findChildViewById(rootView, id);
      if (tilRegFName == null) {
        break missingId;
      }

      id = R.id.til_RegLName;
      TextInputLayout tilRegLName = ViewBindings.findChildViewById(rootView, id);
      if (tilRegLName == null) {
        break missingId;
      }

      id = R.id.til_RegMob;
      TextInputLayout tilRegMob = ViewBindings.findChildViewById(rootView, id);
      if (tilRegMob == null) {
        break missingId;
      }

      id = R.id.til_RegPassword;
      TextInputLayout tilRegPassword = ViewBindings.findChildViewById(rootView, id);
      if (tilRegPassword == null) {
        break missingId;
      }

      id = R.id.txtfname;
      EditText txtfname = ViewBindings.findChildViewById(rootView, id);
      if (txtfname == null) {
        break missingId;
      }

      id = R.id.txtlname;
      EditText txtlname = ViewBindings.findChildViewById(rootView, id);
      if (txtlname == null) {
        break missingId;
      }

      return new ActivityRegistrationBinding((ScrollView) rootView, btnsubmit, contact, email,
          mainContainer2, password, retlogin, shadowView, tilRegEmail, tilRegFName, tilRegLName,
          tilRegMob, tilRegPassword, txtfname, txtlname);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}