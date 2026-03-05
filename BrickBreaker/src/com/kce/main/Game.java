package com.kce.main;

import java.util.Scanner;

import com.kce.bean.Ball;
import com.kce.service.GameService;
import com.kce.util.Board;
import com.kce.util.Direction;

public class Game {

    Board board;
    Ball ball;
    GameService service;

    public Game() {

        board = new Board();
        ball = new Ball(6, 3, 5);

        service = new GameService(board, ball);
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (ball.getLives() > 0) {

            board.display();

            System.out.println("Enter Command (ST / LT / RT): ");

            String cmd = sc.next().toUpperCase();

            Direction dir = Direction.valueOf(cmd);

            service.move(dir);

            System.out.println("Ball count: " + ball.getLives());
        }

        System.out.println("Game Over");
    }
}