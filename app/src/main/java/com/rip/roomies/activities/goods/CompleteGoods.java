package com.rip.roomies.activities.goods;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.GoodController;
import com.rip.roomies.functions.CompleteGoodFunction;
import com.rip.roomies.models.Good;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by michaelzhong on 6/1/16.
 */
public class CompleteGoods extends GenericActivity implements CompleteGoodFunction {
	private static final Logger log = Logger.getLogger(CreateGood.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		int popUpLayoutID = R.layout.activity_confirm_complete_good;

		//Creating inflater
		LayoutInflater layoutInflater = (LayoutInflater) this.getBaseContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		//Inflating popup window layout
		View popupView = layoutInflater.inflate(popUpLayoutID, null);

		//creating pop up window and setting width and height to match parent
		final PopupWindow popupWindow = new PopupWindow(popupView,
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT);
		popupWindow.setFocusable(true);
		popupWindow.update();

		final EditText userInput = (EditText) popupView.findViewById(R.id.amount);
		Button btnYes = (Button) popupView.findViewById(R.id.yes_btn);
		Button btnNo = (Button) popupView.findViewById(R.id.no_btn);

		final double amount = Double.valueOf(userInput.getText().toString());

		final CompleteGoodFunction self = this;
		btnYes.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				GoodController.getController().completeGood(self, good.getId(), amount);
				popupWindow.dismiss();
			}
		});

		btnNo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY,
						ListAllGoods.class.getSimpleName()));
				popupWindow.dismiss();
			}
		});
		popupWindow.showAtLocation(btnYes, Gravity.CENTER, 0, 0);
	}

	@Override
	public void completeGoodFail() {
		Toast.makeText(this, DisplayStrings.CREATE_GOOD_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void completeGoodSuccess(Good good) {
		Intent i = this.getIntent();
		i.putExtra("Good", good);
		this.setResult(Activity.RESULT_OK, i);
		this.finish();
	}
}

