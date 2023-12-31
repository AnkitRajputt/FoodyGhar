// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AppinfomainBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final LinearLayout mainAppLayout;

  @NonNull
  public final LinearLayout mainLayout;

  @NonNull
  public final TextView mainTitle;

  private AppinfomainBinding(@NonNull LinearLayout rootView, @NonNull LinearLayout mainAppLayout,
      @NonNull LinearLayout mainLayout, @NonNull TextView mainTitle) {
    this.rootView = rootView;
    this.mainAppLayout = mainAppLayout;
    this.mainLayout = mainLayout;
    this.mainTitle = mainTitle;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AppinfomainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AppinfomainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.appinfomain, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AppinfomainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.mainAppLayout;
      LinearLayout mainAppLayout = ViewBindings.findChildViewById(rootView, id);
      if (mainAppLayout == null) {
        break missingId;
      }

      LinearLayout mainLayout = (LinearLayout) rootView;

      id = R.id.mainTitle;
      TextView mainTitle = ViewBindings.findChildViewById(rootView, id);
      if (mainTitle == null) {
        break missingId;
      }

      return new AppinfomainBinding((LinearLayout) rootView, mainAppLayout, mainLayout, mainTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
