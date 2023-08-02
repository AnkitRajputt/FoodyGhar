// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.borjabravo.readmoretextview.ReadMoreTextView;
import com.example.foodyghar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CustomBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final ImageView imgAvatar;

  @NonNull
  public final ReadMoreTextView tvAddress;

  @NonNull
  public final TextView tvName;

  @NonNull
  public final TextView tvTime;

  private CustomBinding(@NonNull CardView rootView, @NonNull ImageView imgAvatar,
      @NonNull ReadMoreTextView tvAddress, @NonNull TextView tvName, @NonNull TextView tvTime) {
    this.rootView = rootView;
    this.imgAvatar = imgAvatar;
    this.tvAddress = tvAddress;
    this.tvName = tvName;
    this.tvTime = tvTime;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CustomBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CustomBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.custom, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CustomBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.img_avatar;
      ImageView imgAvatar = ViewBindings.findChildViewById(rootView, id);
      if (imgAvatar == null) {
        break missingId;
      }

      id = R.id.tv_address;
      ReadMoreTextView tvAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress == null) {
        break missingId;
      }

      id = R.id.tv_name;
      TextView tvName = ViewBindings.findChildViewById(rootView, id);
      if (tvName == null) {
        break missingId;
      }

      id = R.id.tv_time;
      TextView tvTime = ViewBindings.findChildViewById(rootView, id);
      if (tvTime == null) {
        break missingId;
      }

      return new CustomBinding((CardView) rootView, imgAvatar, tvAddress, tvName, tvTime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
