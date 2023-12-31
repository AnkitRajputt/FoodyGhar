// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import com.github.ybq.android.spinkit.SpinKitView;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ProfileFragItemImageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView proemail;

  @NonNull
  public final TextView profun;

  @NonNull
  public final CircleImageView proimg;

  @NonNull
  public final RelativeLayout relativeLayout;

  @NonNull
  public final SpinKitView spinKitforprofilefragment;

  private ProfileFragItemImageBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView proemail, @NonNull TextView profun, @NonNull CircleImageView proimg,
      @NonNull RelativeLayout relativeLayout, @NonNull SpinKitView spinKitforprofilefragment) {
    this.rootView = rootView;
    this.proemail = proemail;
    this.profun = profun;
    this.proimg = proimg;
    this.relativeLayout = relativeLayout;
    this.spinKitforprofilefragment = spinKitforprofilefragment;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ProfileFragItemImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ProfileFragItemImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.profile_frag_item_image, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ProfileFragItemImageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.proemail;
      TextView proemail = ViewBindings.findChildViewById(rootView, id);
      if (proemail == null) {
        break missingId;
      }

      id = R.id.profun;
      TextView profun = ViewBindings.findChildViewById(rootView, id);
      if (profun == null) {
        break missingId;
      }

      id = R.id.proimg;
      CircleImageView proimg = ViewBindings.findChildViewById(rootView, id);
      if (proimg == null) {
        break missingId;
      }

      id = R.id.relativeLayout;
      RelativeLayout relativeLayout = ViewBindings.findChildViewById(rootView, id);
      if (relativeLayout == null) {
        break missingId;
      }

      id = R.id.spin_kitforprofilefragment;
      SpinKitView spinKitforprofilefragment = ViewBindings.findChildViewById(rootView, id);
      if (spinKitforprofilefragment == null) {
        break missingId;
      }

      return new ProfileFragItemImageBinding((ConstraintLayout) rootView, proemail, profun, proimg,
          relativeLayout, spinKitforprofilefragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
