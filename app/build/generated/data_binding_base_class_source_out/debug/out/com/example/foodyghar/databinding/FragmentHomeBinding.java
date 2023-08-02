// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import com.github.ybq.android.spinkit.SpinKitView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final RecyclerView rcvUser;

  @NonNull
  public final SpinKitView spinKitforhomefragment;

  private FragmentHomeBinding(@NonNull FrameLayout rootView, @NonNull RecyclerView rcvUser,
      @NonNull SpinKitView spinKitforhomefragment) {
    this.rootView = rootView;
    this.rcvUser = rcvUser;
    this.spinKitforhomefragment = spinKitforhomefragment;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rcv_user;
      RecyclerView rcvUser = ViewBindings.findChildViewById(rootView, id);
      if (rcvUser == null) {
        break missingId;
      }

      id = R.id.spin_kitforhomefragment;
      SpinKitView spinKitforhomefragment = ViewBindings.findChildViewById(rootView, id);
      if (spinKitforhomefragment == null) {
        break missingId;
      }

      return new FragmentHomeBinding((FrameLayout) rootView, rcvUser, spinKitforhomefragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}