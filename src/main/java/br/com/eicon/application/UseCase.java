package br.com.eicon.application;

public abstract class UseCase<INPUT> {
    public abstract void execute(INPUT input);
}
