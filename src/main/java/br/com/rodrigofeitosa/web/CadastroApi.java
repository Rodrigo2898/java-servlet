package br.com.rodrigofeitosa.web;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cadastroApi")
public class CadastroApi extends HttpServlet {
    private static final long serialVersionUID = 1L;
    List<Usuario> usuarios = new ArrayList();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        usuarios.add(new Usuario("Rodrigo", "rodrigo@gmail.com"));
        usuarios.add(new Usuario("Vanessa", "vanessa@gmail.com"));
        usuarios.add(new Usuario("Goku", "goku@gmail.com"));

        Gson gson = new Gson();
        String usuariosConvertidos = gson.toJson(usuarios);

        resp.getWriter().append(usuariosConvertidos);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        String line = "";
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        // System.out.println(sb.toString());

        Gson gson = new Gson();
        var usuario = gson.fromJson(sb.toString(), Usuario.class);
        System.out.println(usuario);

        usuarios.add(usuario);
    }

    record Usuario(String name, String email) {

    }
}
