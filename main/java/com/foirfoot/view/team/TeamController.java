package com.foirfoot.view.team;

import com.foirfoot.model.Facade;
import com.foirfoot.model.club.Club;
import com.foirfoot.model.team.Team;
import com.foirfoot.model.user.User;
import com.foirfoot.view.Controller;
import com.foirfoot.view.Main;
import exceptions.TeamNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.Optional;

public class TeamController extends Controller {
    private final Facade facade = new Facade();
    private Team team;
    @FXML
    private Text teamName;
    @FXML
    private Text numberPlayer;
    @FXML
    private Text category;
    @FXML
    private Text type;
    @FXML
    private VBox players;
    @FXML
    private VBox coaches;

    public void initialize() {
        System.out.println("initialize()");
        teamName.setText(team.getType() + " - " + team.getCategory() + " - " + team.getClub().getName());
        category.setText(team.getCategory());
        type.setText(team.getType());
        try {
            team = facade.getTeam(team.getId());
        } catch (TeamNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(team);

        for (User p : team.getPlayers()) {
            players.getChildren().add(new Text(p.getFirstName() + " " + p.getName()));
        }
        for (User c : team.getCoachs()) {
            coaches.getChildren().add(new Text(c.getFirstName() + " " + c.getName()));
        }
        this.numberPlayer.setText(String.valueOf(team.getPlayers().size()));
    }

    @Override
    public void setParameter(Object[] params) {
        this.team = (Team) params[0];
    }
}
