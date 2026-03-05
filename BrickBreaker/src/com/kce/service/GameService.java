package com.kce.service;

import com.kce.bean.Ball;
import com.kce.bean.Brick;
import com.kce.util.Board;
import com.kce.util.Direction;

public class GameService {

    Board board;
    Ball ball;

    public GameService(Board board, Ball ball) {
        this.board = board;
        this.ball = ball;
    }

    public void move(Direction dir) {

        int r = ball.row;
        int c = ball.col;

        int dr = -1;
        int dc = 0;

        if (dir == Direction.LT)
            dc = -1;
        else if (dir == Direction.RT)
            dc = 1;

        while (true) {

            int nr = r + dr;
            int nc = c + dc;

            Object obj = board.grid[nr][nc];

            if (obj.equals("w"))
                break;

            if (obj instanceof Brick) {

                Brick brick = (Brick) obj;
                brick.hit();

                if (brick.isDestroyed())
                    board.grid[nr][nc] = " ";

                ball.reduceLife();
                break;
            }

            r = nr;
            c = nc;
        }

        updateBallPosition(r, c);
    }

    private void updateBallPosition(int r, int c) {

        board.grid[ball.row][ball.col] = "g";

        ball.row = r;
        ball.col = c;

        board.grid[r][c] = "o";
    }
}