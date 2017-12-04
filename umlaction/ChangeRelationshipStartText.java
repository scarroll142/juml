package umlaction;

import umlobject.*;
import juml.*;

/*
 * Action class for changing relationship start Note text.
 * @author Samuel Carroll
 * @author Torrance Graham
 * @author Quinn Minnich
 * @author Thomas Russoniello
 * @version 0.3
 * @since 0.3
 */
public class ChangeRelationshipStartText extends UMLAction {
  Relationship relationship;
  String alt;

  public ChangeRelationshipStartText(Relationship inRelationship, String newValue,
    Controller inController) {
    controller = inController;
    relationship = inRelationship;
    alt = newValue;
    doInitialAction();
  }

  public void doAction() {
    String temp = alt;
    alt = relationship.getStartText();
    relationship.setStartText(temp);
  }

  public void undoAction() {
    String temp = alt;
    alt = relationship.getStartText();
    relationship.setStartText(temp);
  }

  public void doInitialAction() {
    String temp = alt;
    alt = relationship.getStartText();
    if (!relationship.setStartText(temp)) {
      if (controller.ACTIONS.peek() == this) {
        controller.ACTIONS.pop();
      }
    }
  }
}
