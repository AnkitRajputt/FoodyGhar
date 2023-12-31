// Generated by view binder compiler. Do not edit!
package com.example.foodyghar.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.foodyghar.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTabHomeBooking2Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final TextView bookingCurrentPageRestuarantName;

  @NonNull
  public final TextView bookingCurrentPageText;

  @NonNull
  public final CardView bookingInfoCompleteButton;

  @NonNull
  public final LinearLayout bookingInfoSection;

  @NonNull
  public final CircleImageView bookingPageTopIcon;

  @NonNull
  public final ImageView closeButtonTblbookinfo;

  @NonNull
  public final RelativeLayout coordinatorLayout;

  @NonNull
  public final TextView currentDateTextview;

  @NonNull
  public final TextView foodieCount;

  @NonNull
  public final ElegantNumberButton foodieCountBtn;

  @NonNull
  public final EditText inputEmail;

  @NonNull
  public final EditText inputName;

  @NonNull
  public final EditText inputPhone;

  @NonNull
  public final Button pickDateBtn;

  @NonNull
  public final TextView timeSlotErrortext;

  @NonNull
  public final RecyclerView timeSlotRecyclerview;

  private ActivityTabHomeBooking2Binding(@NonNull RelativeLayout rootView,
      @NonNull TextView bookingCurrentPageRestuarantName, @NonNull TextView bookingCurrentPageText,
      @NonNull CardView bookingInfoCompleteButton, @NonNull LinearLayout bookingInfoSection,
      @NonNull CircleImageView bookingPageTopIcon, @NonNull ImageView closeButtonTblbookinfo,
      @NonNull RelativeLayout coordinatorLayout, @NonNull TextView currentDateTextview,
      @NonNull TextView foodieCount, @NonNull ElegantNumberButton foodieCountBtn,
      @NonNull EditText inputEmail, @NonNull EditText inputName, @NonNull EditText inputPhone,
      @NonNull Button pickDateBtn, @NonNull TextView timeSlotErrortext,
      @NonNull RecyclerView timeSlotRecyclerview) {
    this.rootView = rootView;
    this.bookingCurrentPageRestuarantName = bookingCurrentPageRestuarantName;
    this.bookingCurrentPageText = bookingCurrentPageText;
    this.bookingInfoCompleteButton = bookingInfoCompleteButton;
    this.bookingInfoSection = bookingInfoSection;
    this.bookingPageTopIcon = bookingPageTopIcon;
    this.closeButtonTblbookinfo = closeButtonTblbookinfo;
    this.coordinatorLayout = coordinatorLayout;
    this.currentDateTextview = currentDateTextview;
    this.foodieCount = foodieCount;
    this.foodieCountBtn = foodieCountBtn;
    this.inputEmail = inputEmail;
    this.inputName = inputName;
    this.inputPhone = inputPhone;
    this.pickDateBtn = pickDateBtn;
    this.timeSlotErrortext = timeSlotErrortext;
    this.timeSlotRecyclerview = timeSlotRecyclerview;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTabHomeBooking2Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTabHomeBooking2Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_tab_home_booking2, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTabHomeBooking2Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.booking_current_page_restuarant_name;
      TextView bookingCurrentPageRestuarantName = ViewBindings.findChildViewById(rootView, id);
      if (bookingCurrentPageRestuarantName == null) {
        break missingId;
      }

      id = R.id.booking_current_page_text;
      TextView bookingCurrentPageText = ViewBindings.findChildViewById(rootView, id);
      if (bookingCurrentPageText == null) {
        break missingId;
      }

      id = R.id.booking_info_complete_button;
      CardView bookingInfoCompleteButton = ViewBindings.findChildViewById(rootView, id);
      if (bookingInfoCompleteButton == null) {
        break missingId;
      }

      id = R.id.booking_info_section;
      LinearLayout bookingInfoSection = ViewBindings.findChildViewById(rootView, id);
      if (bookingInfoSection == null) {
        break missingId;
      }

      id = R.id.booking_page_top_icon;
      CircleImageView bookingPageTopIcon = ViewBindings.findChildViewById(rootView, id);
      if (bookingPageTopIcon == null) {
        break missingId;
      }

      id = R.id.close_button_tblbookinfo;
      ImageView closeButtonTblbookinfo = ViewBindings.findChildViewById(rootView, id);
      if (closeButtonTblbookinfo == null) {
        break missingId;
      }

      RelativeLayout coordinatorLayout = (RelativeLayout) rootView;

      id = R.id.current_date_textview;
      TextView currentDateTextview = ViewBindings.findChildViewById(rootView, id);
      if (currentDateTextview == null) {
        break missingId;
      }

      id = R.id.foodie_count;
      TextView foodieCount = ViewBindings.findChildViewById(rootView, id);
      if (foodieCount == null) {
        break missingId;
      }

      id = R.id.foodie_count_btn;
      ElegantNumberButton foodieCountBtn = ViewBindings.findChildViewById(rootView, id);
      if (foodieCountBtn == null) {
        break missingId;
      }

      id = R.id.input_email;
      EditText inputEmail = ViewBindings.findChildViewById(rootView, id);
      if (inputEmail == null) {
        break missingId;
      }

      id = R.id.input_name;
      EditText inputName = ViewBindings.findChildViewById(rootView, id);
      if (inputName == null) {
        break missingId;
      }

      id = R.id.input_phone;
      EditText inputPhone = ViewBindings.findChildViewById(rootView, id);
      if (inputPhone == null) {
        break missingId;
      }

      id = R.id.pick_date_btn;
      Button pickDateBtn = ViewBindings.findChildViewById(rootView, id);
      if (pickDateBtn == null) {
        break missingId;
      }

      id = R.id.time_slot_errortext;
      TextView timeSlotErrortext = ViewBindings.findChildViewById(rootView, id);
      if (timeSlotErrortext == null) {
        break missingId;
      }

      id = R.id.time_slot_recyclerview;
      RecyclerView timeSlotRecyclerview = ViewBindings.findChildViewById(rootView, id);
      if (timeSlotRecyclerview == null) {
        break missingId;
      }

      return new ActivityTabHomeBooking2Binding((RelativeLayout) rootView,
          bookingCurrentPageRestuarantName, bookingCurrentPageText, bookingInfoCompleteButton,
          bookingInfoSection, bookingPageTopIcon, closeButtonTblbookinfo, coordinatorLayout,
          currentDateTextview, foodieCount, foodieCountBtn, inputEmail, inputName, inputPhone,
          pickDateBtn, timeSlotErrortext, timeSlotRecyclerview);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
