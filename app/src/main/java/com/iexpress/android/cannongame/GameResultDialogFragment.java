package com.iexpress.android.cannongame;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;


public class GameResultDialogFragment extends DialogFragment {
    private CannonView view;

    public GameResultDialogFragment() {
        // use newInstance to get new obj
    }


    public static GameResultDialogFragment newInstance(String title, String message,
                                                       CannonView view) {
        GameResultDialogFragment dialogFragment = new GameResultDialogFragment();

        Bundle args = new Bundle();
        args.putString("title", title);
        args.putString("message", message);

        dialogFragment.setArguments(args);
        return  dialogFragment;
    }

    // create an AlertDialog and return it
    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        // create dialog displaying String resource for messageId
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle(getArguments().getString("title"));

        // display number of shots fired and total time elapsed
        builder.setMessage(getArguments().getString("message"));

        builder.setPositiveButton(R.string.reset_game,
                new DialogInterface.OnClickListener() {
                    // called when "Reset Game" Button is pressed
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        if (view != null) {
                            view.setDialogIsDisplayed(false);
                            view.newGame(); // set up and start a new game
                        }
                    }
                }
        );

        return builder.create(); // return the AlertDialog
    }

}
