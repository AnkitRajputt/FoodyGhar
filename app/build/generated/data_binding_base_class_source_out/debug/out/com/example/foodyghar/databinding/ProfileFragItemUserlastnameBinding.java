// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileFragItemUserlastnameBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final EditText prouserlastname;

  private ProfileFragItemUserlastnameBinding(@NonNull CardView rootView,
      @NonNull EditText prouserlastname) {
    this.rootView = rootView;
    this.prouserlastname = prouserlastname;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileFragItemUserlastnameBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileFragItemUserlastnameBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_frag_item_userlastname, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileFragItemUserlastnameBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.prouserlastname;
      EditText prouserlastname = ViewBindings.findChildViewById(rootView, id);
      if (prouserlastname == null) {
        break missingId;
      }

      return new ProfileFragItemUserlastnameBinding((CardView) rootView, prouserlastname);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}