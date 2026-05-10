import { renderHook, waitFor } from "@testing-library/react";
import { usePlayers } from "./usePlayers";
import * as client from "../../api/client";

vi.mock("../../api/client", () => ({
  apiFetch: vi.fn(),
}));

describe("usePlayers", () => {
  beforeEach(() => {
    vi.clearAllMocks();
  });

  it("initialement: loading=true, players vide", () => {
    vi.mocked(client.apiFetch).mockReturnValue(new Promise(() => {})); // jamais résolu
    const { result } = renderHook(() => usePlayers());

    expect(result.current.loading).toBe(true);
    expect(result.current.players).toEqual([]);
    expect(result.current.error).toBeNull();
  });

  it("charge et retourne les joueurs en cas de succès", async () => {
    const fakePlayers = [{ id: "1", name: "Isaac", skin: "x.png" }];
    vi.mocked(client.apiFetch).mockResolvedValue(fakePlayers);

    const { result } = renderHook(() => usePlayers());

    await waitFor(() => expect(result.current.loading).toBe(false));
    expect(result.current.players).toEqual(fakePlayers);
    expect(result.current.error).toBeNull();
  });

  it("expose le message d'erreur en cas d'échec", async () => {
    vi.mocked(client.apiFetch).mockRejectedValue(new Error("Network down"));

    const { result } = renderHook(() => usePlayers());

    await waitFor(() => expect(result.current.loading).toBe(false));
    expect(result.current.error).toBe("Network down");
    expect(result.current.players).toEqual([]);
  });
});
