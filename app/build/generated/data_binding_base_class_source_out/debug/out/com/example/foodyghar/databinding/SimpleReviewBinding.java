// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.foodyghar.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SimpleReviewBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView restRateCardtext;

  @NonNull
  public final TextView restRateTv;

  @NonNull
  public final RatingBar restRatingbar;

  @NonNull
  public final TextView revDes;

  @NonNull
  public final CircleImageView revImg;

  @NonNull
  public final TextView revUser;

  private SimpleReviewBinding(@NonNull CardView rootView, @NonNull TextView restRateCardtext,
      @NonNull TextView restRateTv, @NonNull RatingBar restRatingbar, @NonNull TextView revDes,
      @NonNull CircleImageView revImg, @NonNull TextView revUser) {
    this.rootView = rootView;
    this.restRateCardtext = restRateCardtext;
    this.restRateTv = restRateTv;
    this.restRatingbar = restRatingbar;
    this.revDes = revDes;
    this.revImg = revImg;
    this.revUser = revUser;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static SimpleReviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SimpleReviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.simple_review, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SimpleReviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.rest_rate_cardtext;
      TextView restRateCardtext = ViewBindings.findChildViewById(rootView, id);
      if (restRateCardtext == null) {
        break missingId;
      }

      id = R.id.rest_rate_tv;
      TextView restRateTv = ViewBindings.findChildViewById(rootView, id);
      if (restRateTv == null) {
        break missingId;
      }

      id = R.id.rest_ratingbar;
      RatingBar restRatingbar = ViewBindings.findChildViewById(rootView, id);
      if (restRatingbar == null) {
        break missingId;
      }

      id = R.id.rev_des;
      TextView revDes = ViewBindings.findChildViewById(rootView, id);
      if (revDes == null) {
        break missingId;
      }

      id = R.id.rev_img;
      CircleImageView revImg = ViewBindings.findChildViewById(rootView, id);
      if (revImg == null) {
        break missingId;
      }

      id = R.id.rev_user;
      TextView revUser = ViewBindings.findChildViewById(rootView, id);
      if (revUser == null) {
        break missingId;
      }

      return new SimpleReviewBinding((CardView) rootView, restRateCardtext, restRateTv,
          restRatingbar, revDes, revImg, revUser);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
