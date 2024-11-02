package com.example.mobile_athleta.UseCase;


import com.example.mobile_athleta.models.Forum;
import com.example.mobile_athleta.service.ApiResponse;
import com.example.mobile_athleta.service.AthletaService;
import com.example.mobile_athleta.service.ForumResponse;
import com.example.mobile_athleta.service.RetrofitClientSql;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListarForumPorNomeUseCase {

    public interface VerificarCallback {
        void onVerificarSuccess(List<Forum> foruns, String message);
        void onVerificarFailure(String errorMessage);
    }

    public void verificarForuns(String token,String nome, VerificarCallback callback) {
        AthletaService service = RetrofitClientSql.getAthletaService();
        Call<ForumResponse> call = service.listarForunsPorNome(token, nome);

        call.enqueue(new Callback<ForumResponse>() {
            @Override
            public void onResponse(Call<ForumResponse> call, Response<ForumResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ForumResponse forumResponse = response.body();
                    List<Forum> foruns = forumResponse.getForums();
                    if (foruns != null && !foruns.isEmpty()) {
                        callback.onVerificarSuccess(foruns, "");
                    } else {
                        callback.onVerificarFailure("Nenhum fórum encontrado");
                    }
                } else {
                    callback.onVerificarFailure("Erro ao obter postagens");
                }
            }


            @Override
            public void onFailure(Call<ForumResponse> call, Throwable throwable) {
                callback.onVerificarFailure("Falha na chamada da API: " + throwable.getMessage());
            }
        });
    }
}
