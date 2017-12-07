package umlaction;

import juml.*;
import umlobject.*;

/**
 * Action class for moving a UMLNode.
 * @author Samuel Carroll
 * @author Torrance Graham
 * @author Quinn Minnich
 * @author Thomas Russoniello
 * @version 0.3
 * @since 0.3
 */
public class MoveUMLNode extends UMLNodeAction {
  
  /** 
   * The original x and y coordinates followed by the new x and y coordinates.
   */
  double originalX, originalY, movedX, movedY;
  
  /** 
   * Boolean representing whether move at first is true or false. 
   */
  boolean moveAtFirst;
  
  /** 
   * The uml node controller. 
   */
  UMLNodeController umlNodeController;

  /**
   * Instantiates a new move UML node.
   *
   * @param inNode the in node
   * @param inOriginalX the in original X
   * @param inOriginalY the in original Y
   * @param inUMLNodeController the in UML node controller
   */
  public MoveUMLNode(UMLNode inNode, double inOriginalX, double inOriginalY,
    UMLNodeController inUMLNodeController) {
    this(inNode, inOriginalX, inOriginalY, inUMLNodeController, true);
  }

  /**
   * Instantiates a new move UML node.
   *
   * @param inNode the in node
   * @param inOriginalX the in original X
   * @param inOriginalY the in original Y
   */
  public MoveUMLNode(UMLNode inNode, double inOriginalX, double inOriginalY) {
    this(inNode, inOriginalX, inOriginalY, null, true);
  }

  /**
   * Instantiates a new move UML node.
   *
   * @param inNode the in node
   * @param inOriginalX the in original X
   * @param inOriginalY the in original Y
   * @param inMoveAtFirst the in move at first
   */
  public MoveUMLNode(UMLNode inNode, double inOriginalX, double inOriginalY, boolean inMoveAtFirst) {
    this(inNode, inOriginalX, inOriginalY, null, inMoveAtFirst);
  }

  /**
   * Instantiates a new move UML node.
   *
   * @param inNode the in node
   * @param inOriginalX the in original X
   * @param inOriginalY the in original Y
   * @param inUMLNodeController the in UML node controller
   * @param inMoveAtFirst the in move at first
   */
  public MoveUMLNode(UMLNode inNode, double inOriginalX, double inOriginalY, UMLNodeController inUMLNodeController, boolean inMoveAtFirst) {
    if (inNode != null) {
      node = inNode;
      umlNodeController = inUMLNodeController;
      originalX = inOriginalX;
      originalY = inOriginalY;
      movedX = node.getOriginX();
      movedY = node.getOriginY();
      if (moveAtFirst = inMoveAtFirst) {
        doAction();
      }
    }
  }

  /**
   * @see umlaction.UMLAction#doAction()
   */
  public void doAction() {
    if (moveAtFirst) {
      node.move(originalX, originalY);
      if (umlNodeController != null) {
        umlNodeController.setOriginCoordinatesText(originalX, originalY);
      }
    } else {
      node.move(movedX, movedY);
      if (umlNodeController != null) {
        umlNodeController.setOriginCoordinatesText(movedX, movedY);
      }
    }
  }

  /**
   * @see umlaction.UMLAction#undoAction()
   */
  public void undoAction() {
    if (moveAtFirst) {
      node.move(movedX, movedY);
      if (umlNodeController != null) {
        umlNodeController.setOriginCoordinatesText(movedX, movedY);
      }
    } else {
      node.move(originalX, originalY);
      if (umlNodeController != null) {
        umlNodeController.setOriginCoordinatesText(originalX, originalY);
      }
    }
  }
}
