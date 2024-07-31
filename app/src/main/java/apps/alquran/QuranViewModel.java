package apps.alquran;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import org.w3c.dom.Entity;

import java.util.List;

import javax.inject.Inject;

import apps.alquran.room.QuranDao;
import apps.alquran.room.QuranEntity;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class QuranViewModel extends ViewModel {
    private final QuranDao dao;
    private final LiveData<List<QuranEntity>> entity;

    @Inject
    public QuranViewModel(QuranDao dao) {
        this.dao = dao;
        this.entity = dao.getQuran();
    }

    public LiveData<List<QuranEntity>> getQuranList() {
        return entity;
    }

    public void addAyat(QuranEntity entity) {
        dao.save(entity);
    }

    public void getList() {
        dao.getQuran();
    }
}
