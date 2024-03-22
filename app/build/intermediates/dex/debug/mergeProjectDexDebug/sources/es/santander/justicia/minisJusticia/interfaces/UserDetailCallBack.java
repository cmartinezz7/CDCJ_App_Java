package es.santander.justicia.minisJusticia.interfaces;

import es.santander.justicia.minisJusticia.dto.UserDetailDTO;

public interface UserDetailCallBack {
    void onFinishUserDetailData(UserDetailDTO userDetailDTO, boolean z);
}
