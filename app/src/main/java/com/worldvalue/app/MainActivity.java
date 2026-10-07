package com.worldvalue.app;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showHome();
    }

    TextView title(String text) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(24);
        t.setTextColor(Color.rgb(40, 40, 40));
        t.setPadding(20, 30, 20, 20);
        return t;
    }

    Button button(String text, View.OnClickListener listener) {
        Button b = new Button(this);
        b.setText(text);
        b.setOnClickListener(listener);
        return b;
    }

    void base(String heading) {
        layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);

        ScrollView scroll = new ScrollView(this);
        scroll.addView(layout);
        setContentView(scroll);

        layout.addView(title(heading));
    }

    void showHome() {
        base("WorldValue");

        TextView welcome = new TextView(this);
        welcome.setText("Solve problems. Create value. Share the rewards.");
        welcome.setTextSize(18);
        welcome.setPadding(20, 10, 20, 30);
        layout.addView(welcome);

        layout.addView(button("Explore Problems", v -> showProblems()));
        layout.addView(button("Post a Problem", v -> postProblem()));
        layout.addView(button("My Projects", v -> projects()));
        layout.addView(button("Contribution Ledger", v -> ledger()));
        layout.addView(button("Wallet", v -> wallet()));
        layout.addView(button("My Profile", v -> profile()));
    }

    void showProblems() {
        base("Explore Problems");

        addProblem("Clean Water Project",
                "Looking for practical solutions for clean drinking water.");

        addProblem("Affordable Housing",
                "Ideas for low-cost and sustainable housing.");

        addProblem("Small Business Growth",
                "Ways to help small businesses increase their income.");

        layout.addView(button("← Home", v -> showHome()));
    }

    void addProblem(String name, String description) {
        TextView p = new TextView(this);
        p.setText(name + "\n" + description);
        p.setTextSize(17);
        p.setPadding(20, 20, 20, 20);
        layout.addView(p);

        layout.addView(button("View & Submit Solution",
                v -> submitSolution(name)));
    }

    void submitSolution(String problem) {
        base("Submit Solution");

        TextView t = new TextView(this);
        t.setText("Problem: " + problem);
        t.setTextSize(18);
        t.setPadding(20, 10, 20, 20);
        layout.addView(t);

        EditText solution = new EditText(this);
        solution.setHint("Describe your solution...");
        solution.setMinLines(6);
        layout.addView(solution);

        layout.addView(button("Submit Solution", v ->
                Toast.makeText(this, "Solution submitted!", Toast.LENGTH_LONG).show()));

        layout.addView(button("← Back", v -> showProblems()));
    }

    void postProblem() {
        base("Post a Problem");

        EditText problem = new EditText(this);
        problem.setHint("What problem do you want solved?");
        problem.setMinLines(5);
        layout.addView(problem);

        EditText reward = new EditText(this);
        reward.setHint("Budget / reward amount");
        layout.addView(reward);

        layout.addView(button("Post Problem", v ->
                Toast.makeText(this, "Problem posted!", Toast.LENGTH_LONG).show()));

        layout.addView(button("← Home", v -> showHome()));
    }

    void projects() {
        base("My Projects");

        TextView p = new TextView(this);
        p.setText("No active projects yet.\n\nAccepted solutions will appear here.");
        p.setTextSize(18);
        p.setPadding(20, 20, 20, 30);
        layout.addView(p);

        layout.addView(button("← Home", v -> showHome()));
    }

    void ledger() {
        base("Contribution Ledger");

        TextView l = new TextView(this);
        l.setText("Project contribution records\n\nNo contributions recorded yet.");
        l.setTextSize(18);
        l.setPadding(20, 20, 20, 30);
        layout.addView(l);

        layout.addView(button("← Home", v -> showHome()));
    }

    void wallet() {
        base("Wallet");

        TextView w = new TextView(this);
        w.setText("Available Balance\n\n£0.00\n\nWorldValue service fee: 10%");
        w.setTextSize(20);
        w.setPadding(20, 20, 20, 30);
        layout.addView(w);

        layout.addView(button("← Home", v -> showHome()));
    }

    void profile() {
        base("My Profile");

        TextView p = new TextView(this);
        p.setText("WorldValue Member\n\nAccount status: Free");
        p.setTextSize(18);
        p.setPadding(20, 20, 20, 30);
        layout.addView(p);

        layout.addView(button("← Home", v -> showHome()));
    }
}
