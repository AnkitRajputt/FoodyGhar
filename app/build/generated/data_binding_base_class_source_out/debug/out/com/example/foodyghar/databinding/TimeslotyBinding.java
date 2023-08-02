// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TimeslotyBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final RadioGroup actionChip1;

  @NonNull
  public final TextView slottime;

  private TimeslotyBinding(@NonNull LinearLayout rootView, @NonNull RadioGroup actionChip1,
      @NonNull TextView slottime) {
    this.rootView = rootView;
    this.actionChip1 = actionChip1;
    this.slottime = slottime;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TimeslotyBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TimeslotyBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.timesloty, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TimeslotyBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_chip1;
      RadioGroup actionChip1 = ViewBindings.findChildViewById(rootView, id);
      if (actionChip1 == null) {
        break missingId;
      }

      id = R.id.slottime;
      TextView slottime = ViewBindings.findChildViewById(rootView, id);
      if (slottime == null) {
        break missingId;
      }

      return new TimeslotyBinding((LinearLayout) rootView, actionChip1, slottime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
