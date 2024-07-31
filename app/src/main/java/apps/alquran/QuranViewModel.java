package apps.alquran;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;

import apps.alquran.room.QuranDao;
import apps.alquran.room.QuranEntity;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class QuranViewModel extends ViewModel {
    private final QuranDao dao;
    private final LiveData<List<QuranEntity>> entity;
    private final Executor executor;

    @Inject
    public QuranViewModel(QuranDao dao) {
        this.dao = dao;
        this.entity = dao.getQuran();
        this.executor = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<QuranEntity>> getQuranList() {
        return entity;
    }

    public void addAyat(final QuranEntity entity) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                dao.save(entity);
            }
        });
    }

    public void getList() {
        dao.getQuran();
    }
}
