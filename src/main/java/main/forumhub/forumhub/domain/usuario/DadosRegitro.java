package main.forumhub.forumhub.domain.usuario;

public record DadosRegitro(String email, String nome) {
    public DadosRegitro(String email) {
        this(email, null);
    }
    
    public DadosRegitro(Usuario newUser){
        this(newUser.getEmail());
    }
}
