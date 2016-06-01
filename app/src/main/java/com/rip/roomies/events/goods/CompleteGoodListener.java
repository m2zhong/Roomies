package com.rip.roomies.events.goods;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.goods.CompleteGoods;
import com.rip.roomies.activities.goods.ListAllGoods;
import com.rip.roomies.functions.CompleteGoodFunction;
import com.rip.roomies.models.Good;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.views.GoodView;

import java.util.Locale;
import java.util.logging.Logger;


/**
 * Created by michaelzhong on 5/31/16.
 */
public class CompleteGoodListener implements View.OnClickListener, CompleteGoodFunction {
	private ListAllGoods context;
	private Good good;
	private int popUpLayoutID;
	private GoodView goodview;
	private static final Logger log = Logger.getLogger(CompleteGoodListener.class.getName());
	private double amount; //for bill $ amount
	public static final int COMPLETE_GOOD = 4;

	/**
	 * CONSTRUCTOR
	 *
	 * @param context Activity calling the listener class
	 * @param good    The good to be modified
	 */
	public CompleteGoodListener(ListAllGoods context, GoodView goodview, Good good) {
		this.context = context;
		this.good = good;
		this.goodview = goodview;
		this.popUpLayoutID = R.layout.activity_confirm_complete_good;
	}

	@Override
	public void onClick(View v) {

		log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY,
				CompleteGoods.class.getSimpleName()));



		/*
		int popUpLayoutID = R.layout.activity_confirm_complete_good;

		//Creating inflater
		LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

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

		amount = Double.valueOf(userInput.getText().toString());

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
		popupWindow.showAtLocation(btnYes, Gravity.CENTER, 0, 0);*/
	}
		@Override
		public void completeGoodFail() {
			Toast.makeText(context, DisplayStrings.CREATE_GOOD_FAIL, Toast.LENGTH_LONG).show();
		}

		@Override
		public void completeGoodSuccess (Good good){
			Intent i = context.getIntent();
			i.putExtra("Good", good);
			context.setResult(Activity.RESULT_OK, i);
			context.finish();
		}
	}

