package com.jincompany.dailystudy.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jincompany.dailystudy.DBmanagerService.smsDBManager.SmsDBManager;
import com.jincompany.dailystudy.R;
import com.jincompany.dailystudy.sms.DTO.SmsDTO;
import com.jincompany.dailystudy.utility.DateUtility;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainPage extends AppCompatActivity {

    private TextView rest_of_budget_var;
    private int monthly_budget_int;
    private String monthly_budget;
    private int expenditure;
    private TextView expenditure_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        /*
          1.
         */

        // start 날짜 셋업
        TextView date_text = (TextView) findViewById(R.id.date_text);
        DateUtility dateUtility = new DateUtility();
        date_text.setText(dateUtility.getNowDateWithFormat("yyyy.MM.dd"));
        // end 날짜 셋업

        expenditure_var = (TextView) findViewById(R.id.expenditure_var); // 지출 금액
        rest_of_budget_var = (TextView) findViewById(R.id.rest_of_budget_var); // 남은 금액

        // 문자 메세지 데이터 가져옴
        SmsDBManager smsDBManager = new SmsDBManager("content://sms/inbox", getApplicationContext());

        List<SmsDTO> sms_list= smsDBManager.selectSMSData();

        Pattern p = Pattern.compile("(\\S*)won");
        expenditure = 0;
        for (SmsDTO e : sms_list) {
            Matcher m = p.matcher(e.getContent());

            while (m.find()) {
               // 지출 합계 계산
                expenditure += Integer.parseInt(m.group(1).replaceAll(",", ""));
                Log.d("jin", m.group(1));
            }
        }
        // end 지출 합계 계산
        // 총 지출 화폐로 셋업
        expenditure_var.setText(getCurrencyFormat(expenditure));

        int rest_of_budget = 0;
        // 한달 예산 값이 있으면 남은 예산 계산
        if (monthly_budget != null) {
            rest_of_budget = Integer.parseInt(monthly_budget) - expenditure;
        }
        // 남은 예산 화페로 셋업
        rest_of_budget_var.setText(getCurrencyFormat(rest_of_budget));
    }

    @NonNull
    /**
     * int 값을 화페 단위로 변경
     */
    private String getCurrencyFormat(int won) {
        return NumberFormat.getCurrencyInstance(Locale.KOREA).format(won);
    }

    /**
     * 한달 예산 editText클릭
     */
    public void monthlyBudgetClicked(View view) {
        // 한달예산 클릭값 가져옮
        monthly_budget = ((EditText) findViewById(R.id.monthly_budget)).getText().toString();
        // 한달 예산 입력값이 있으면
        if (!monthly_budget.equals("")) {
            monthly_budget_int = Integer.parseInt(monthly_budget);
            ((TextView) findViewById(R.id.monthly_budget_var)).setText(getCurrencyFormat(monthly_budget_int));
            ((EditText) findViewById(R.id.monthly_budget)).setText("");
            rest_of_budget_var.setText(getCurrencyFormat(monthly_budget_int - expenditure));
        }
    }

    /**
     * 지출 사항을 자세히 볼 수 있는 페이지로 이동
     */
    public void checkExpenditureBtClicked(View view){

    }
}
