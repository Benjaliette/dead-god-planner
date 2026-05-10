import { render, screen } from "@testing-library/react";
import { PlayerCard } from "./PlayerCard";
import type { Player } from "../types/player";

const mockPlayer: Player = {
  itGame: 1,
  name: "Isaac",
  skin: "http://localhost:8080/assets/skins/isaac.png",
} as Player;

describe("PlayerCard", () => {
  it("affiche le nom du joueur", () => {
    render(<PlayerCard player={mockPlayer} />);
    expect(screen.getByRole("heading", { name: "Isaac" })).toBeInTheDocument();
  });

  it("applique le bon style de sprite (taille, position, scale)", () => {
    const { container } = render(<PlayerCard player={mockPlayer} />);

    const spriteDiv = container.querySelector(
      "div > div > div",
    ) as HTMLDivElement;

    expect(spriteDiv).toBeInTheDocument();
    expect(spriteDiv.style.width).toBe("128px");
    expect(spriteDiv.style.height).toBe("128px");
    expect(spriteDiv.style.backgroundImage).toContain(mockPlayer.skin);
    expect(spriteDiv.style.backgroundPosition).toBe("0px -400px");
    expect(spriteDiv.style.backgroundSize).toBe("1024px 1024px");
    expect(spriteDiv.style.imageRendering).toBe("pixelated");
  });
});
