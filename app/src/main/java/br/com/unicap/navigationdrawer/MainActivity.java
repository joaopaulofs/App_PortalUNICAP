package br.com.unicap.navigationdrawer;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import br.com.unicap.navigationdrawer.disciplina.DisciplinaListView;
import br.com.unicap.navigationdrawer.evento.EventListView;
import br.com.unicap.navigationdrawer.post.PostListView;
import br.com.unicap.navigationdrawer.professor.ProfessorListView;
import br.com.unicap.navigationdrawer.sobre.Sobre;

public class MainActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);
        getSupportActionBar().setTitle(R.string.title_section1);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        switch (position) {
            case 0:
                mTitle = getString(R.string.app_name);
<<<<<<< HEAD
                getSupportActionBar().setTitle(R.string.title_section1);
                getSupportActionBar().setSubtitle("");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Post)));
=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
                fragment = new PostListView();
                break;
            case 1:
                //Disciplinas
                mTitle = getString(R.string.title_section2);
<<<<<<< HEAD
                getSupportActionBar().setTitle(R.string.title_section2);
                getSupportActionBar().setSubtitle("");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Disciplina)));
=======
>>>>>>> f936e96312af008d8a8a3ff18212b2bc9ab99d2b
                fragment = new DisciplinaListView();
                break;
            case 2:
                //Professores
                mTitle = getString(R.string.title_section3);
                getSupportActionBar().setTitle("Corpo Docente");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Professor)));
                getSupportActionBar().setSubtitle("Professores");
                fragment = new ProfessorListView();
                break;
            case 3:
                //Eventos
                mTitle = "Eventos";
                getSupportActionBar().setTitle(R.string.title_section4);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Evento)));
                getSupportActionBar().setSubtitle("Eventos do Curso");
                fragment = new EventListView();
                break;
            case 4:
                //Sobre
                mTitle = "Sobre";
                getSupportActionBar().setTitle("Sobre");
                getSupportActionBar().setSubtitle("");
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Sobre)));
                fragment = new Sobre();
                break;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        String[] stringArray = getResources().getStringArray(R.array.section_titles);
        if (number >= 1) {
            mTitle = stringArray[number - 1];
        }
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

            return true;
        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
