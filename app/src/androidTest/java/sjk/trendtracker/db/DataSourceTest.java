package sjk.trendtracker.db;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import sjk.trendtracker.db.model.Trend;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(AndroidJUnit4.class)
public class DataSourceTest {
    private DataSource mDataSource;

    @Before
    public void setUp(){
        mDataSource = new DataSource(InstrumentationRegistry.getTargetContext());
        mDataSource.open();
    }

    @After
    public void finish() {
        mDataSource.close();
    }

    @Test
    public void testPreConditions() {
        assertNotNull(mDataSource);
    }

    @Test
    public void testShouldAddTrend() throws Exception {
        mDataSource.createTrend("AUD");
        List<Trend> trends = mDataSource.getAllTrends();

        assertThat(trends.size(), is(1));
        assertTrue(trends.get(0).getName().equals("AUD"));
    }

    @Test
    public void testDeleteAll() {
        mDataSource.deleteAll();
        List<Trend> trends = mDataSource.getAllTrends();

        assertThat(trends.size(), is(0));
    }

    @Test
    public void testDeleteOnlyOne() {
        mDataSource.createTrend("AUD");
        List<Trend> trends = mDataSource.getAllTrends();

        assertThat(trends.size(), is(1));

        mDataSource.deleteTrend(trends.get(0));
        trends = mDataSource.getAllTrends();

        assertThat(trends.size(), is(0));
    }

    @Test
    public void testAddAndDelete() {
        mDataSource.deleteAll();
        mDataSource.createTrend("AUD");
        mDataSource.createTrend("JPY");
        mDataSource.createTrend("BGN");

        List<Trend> trends = mDataSource.getAllTrends();
        assertThat(trends.size(), is(3));

        mDataSource.deleteTrend(trends.get(0));
        mDataSource.deleteTrend(trends.get(1));

        trends = mDataSource.getAllTrends();
        assertThat(trends.size(), is(1));
    }
}