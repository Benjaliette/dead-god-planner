import { render, screen, waitFor } from "@testing-library/react";
import { PlayersPage } from "./PlayersPage";
import * as client from "../../api/client";

vi.mock("../../api/client", () => ({
  apiFetch: vi.fn(),
}));

describe("PlayersPage (intégration)", () => {
  it("affiche les cartes des joueurs après chargement", async () => {
    vi.mocked(client.apiFetch).mockResolvedValue([
      { id: "1", name: "Isaac", skin: "isaac.png" },
      { id: "2", name: "Magdalene", skin: "mag.png" },
    ]);

    render(<PlayersPage />);

    await waitFor(() => {
      expect(screen.getByText("Isaac")).toBeInTheDocument();
      expect(screen.getByText("Magdalene")).toBeInTheDocument();
    });
  });

  it("affiche un message d'erreur si l'API échoue", async () => {
    vi.mocked(client.apiFetch).mockRejectedValue(new Error("boom"));
    render(<PlayersPage />);
    await waitFor(() => expect(screen.getByText(/boom/i)).toBeInTheDocument());
  });
});
