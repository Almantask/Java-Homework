package Advent;

import java.util.ArrayList;
import java.util.List;

public class Day20 {

    public static void solve(List<String> input) {

        System.out.println();
        System.out.println("The answer of Day20 part 1 is: " + solvePart1(input));
        System.out.println();
        System.out.println("The answer of Day20 part 2 is: " + solvePart2(input));
    }

    private static Long solvePart1(List<String> input) {
        return findCornersIDs(input).stream().reduce((long) 1, (a, b) -> a * b);
    }

    private static int solvePart2(List<String> input) {
        int countAllGrill = 0;
        for (String row : getActualImage(input))
            countAllGrill += row.length() - row.replaceAll("#", "").length();
        return countAllGrill - findSeaMonster(input);
    }

    private static int findSeaMonster(List<String> input) {
        int countMonsterParts = 0;
        List<List<String>> allPossibleImages = new ArrayList<>();
        List<String> actualImage = getActualImage(input);
        while (allPossibleImages.size() < 8) {
            allPossibleImages.add(actualImage);
            allPossibleImages.add(getFlippedTile(actualImage));
            actualImage = new ArrayList<>(getRotatedTile(actualImage));
        }
        for (List<String> image : allPossibleImages)
            for (int i = 0; i < image.size() - 2; i++) {
                int monsters = isHereSeaMonster(image.get(i), image.get(i + 1), image.get(i + 2));
                if (monsters > 0)
                    countMonsterParts += 15 * monsters;
            }
        return countMonsterParts;
    }

    private static int isHereSeaMonster(String row1, String row2, String row3) {
        int isHereMonster = 0;
        for (int i = 18; i < row1.length() - 1; i++) {                                // "                  # "
            int[] indexes2 = {i - 18, i - 13, i - 12, i - 7, i - 6, i - 1, i, i + 1}; // "#    ##    ##    ###"
            int[] indexes3 = {i - 17, i - 14, i - 11, i - 8, i - 5, i - 2};           // " #  #  #  #  #  #   "
            if (row1.charAt(i) == '#')
                if (checkMonstersLine(indexes2, row2))
                    if (checkMonstersLine(indexes3, row3))
                        isHereMonster += 1;
        }
        return isHereMonster;
    }

    private static boolean checkMonstersLine(int[] indexes, String row) {
        int countMatches = 0;
        for (int i : indexes)
            if (row.charAt(i) == '#')
                countMatches += 1;
        return countMatches == indexes.length;
    }

    private static List<String> getActualImage(List<String> input) {
        List<String> actualImage = new ArrayList<>();
        for (List<List<String>> lineOfTiles : getRearrangedTiles(input))
            for (int i = 0; i < getTileWithoutBorders(lineOfTiles.get(0)).size(); i++) {
                StringBuilder lineOfImage = new StringBuilder();
                for (List<String> tile : lineOfTiles)
                    lineOfImage.append(getTileWithoutBorders(tile).get(i));
                actualImage.add(lineOfImage.toString());
            }
        return actualImage;
    }

    private static List<String> getTileWithoutBorders(List<String> tile) {
        List<String> tileWithoutBorders = new ArrayList<>();
        for (int i = 2; i < tile.size() - 1; i++) {
            String row = tile.get(i);
            tileWithoutBorders.add(row.substring(1, row.length() - 1));
        }
        return tileWithoutBorders;
    }

    private static List<List<List<String>>> getRearrangedTiles(List<String> input) {
        List<List<List<String>>> rearrangedTiles = new ArrayList<>();
        List<String> firstTile = getFirstCorner(input);
        int usedTiles = 0;
        while (usedTiles < splitInputToTiles(input).size()) {
            List<List<String>> lineOfTiles = (getLineOfTiles(firstTile, input));
            rearrangedTiles.add(lineOfTiles);
            firstTile = findFirstTile(firstTile, input);
            usedTiles += lineOfTiles.size();
        }
        return rearrangedTiles;
    }

    private static List<List<String>> getLineOfTiles(List<String> firstTile, List<String> input) {
        List<List<String>> lineOfTiles = new ArrayList<>();
        lineOfTiles.add(firstTile);
        while (true) {
            String lastBorder = getVerticalBorders(lineOfTiles.get(lineOfTiles.size() - 1)).get(1);
            if (!borderHasEquivalent(lastBorder, input)) break;
            lineOfTiles.add(findTileWithMatchingBorder(lineOfTiles.get(lineOfTiles.size() - 1), input));
        }
        return lineOfTiles;
    }

    private static List<String> findTileWithMatchingBorder(List<String> tile1, List<String> input) {
        List<String> matchingTile = new ArrayList<>();
        String matchingBorder = getVerticalBorders(tile1).get(1);
        for (List<String> tile : splitInputToTiles(input)) {
            if (tile1.get(0).equals(tile.get(0)))
                continue;
            for (String border : getAllBordersOfTile(tile)) {
                if (matchingBorder.equals(flipRow(border))) {
                    matchingTile = tile;
                    break;
                }
                if (matchingBorder.equals(border)) {
                    matchingTile = getFlippedTile(tile);
                    break;
                }
            }
        }
        while (!getVerticalBorders(matchingTile).get(0).equals(flipRow(matchingBorder)))
            matchingTile = getRotatedTile(matchingTile);
        return matchingTile;
    }

    private static List<String> findFirstTile(List<String> upperTile, List<String> input) {
        List<String> firstTile = new ArrayList<>();
        String matchingBorder = flipRow(getHorizontalBorders(upperTile).get(1));
        for (List<String> tile : splitInputToTiles(input)) {
            if (upperTile.get(0).equals(tile.get(0)))
                continue;
            for (String border : getAllBordersOfTile(tile)) {
                if (matchingBorder.equals(border)) {
                    firstTile = tile;
                    break;
                }
                if (matchingBorder.equals(flipRow(border))) {
                    firstTile = getFlippedTile(tile);
                    break;
                }
            }
        }
        while (!firstTile.isEmpty() && !getHorizontalBorders(firstTile).get(0).equals(matchingBorder))
            firstTile = getRotatedTile(firstTile);
        return firstTile;
    }

    private static List<String> getFirstCorner(List<String> input) {
        List<String> firstCorner = findCorners(input).get(0);
        while (true) {
            String upperBorder = getHorizontalBorders(firstCorner).get(0);
            String leftBorder = getVerticalBorders(firstCorner).get(0);
            if (!borderHasEquivalent(upperBorder, input) && !borderHasEquivalent(leftBorder, input)) break;
            firstCorner = getRotatedTile(firstCorner);
        }
        return firstCorner;
    }

    private static List<Long> findCornersIDs(List<String> input) {
        List<Long> cornerTilesID = new ArrayList<>();
        for (List<String> tile : findCorners(input))
            cornerTilesID.add(Long.parseLong(tile.get(0)));
        return cornerTilesID;
    }

    private static List<List<String>> findCorners(List<String> input) {
        List<List<String>> corners = new ArrayList<>();
        for (List<String> tile : splitInputToTiles(input)) {
            int matchingBorders = 0;
            List<String> tileBorders = getAllBordersOfTile(tile);
            for (String border : tileBorders)
                if (borderHasEquivalent(border, input) || borderHasEquivalent(flipRow(border), input))
                    matchingBorders += 1;
            if (matchingBorders == 2) {
                corners.add(tile);
            }
        }
        return corners;
    }

    private static boolean borderHasEquivalent(String border, List<String> input) {
        boolean match = false;
        int countMatching = 0;
        for (List<String> tile : splitInputToTiles(input)) {
            for (String checkingBorder : getAllBordersOfTile(tile))
                if (border.equals(checkingBorder) || flipRow(border).equals(checkingBorder)) {
                    countMatching += 1;
                }
            if (countMatching == 2) {
                match = true;
                break;
            }
        }
        return match;
    }

    private static List<String> getFlippedTile(List<String> tile) {
        List<String> flippedTile = new ArrayList<>();
        if (tile.get(0).length() != tile.get(1).length()) {
            String tileID = tile.get(0);
            flippedTile.add(tileID);
            tile.remove(tileID);
        }
        for (String s : tile)
            flippedTile.add(new StringBuilder(s).reverse().toString());
        return flippedTile;
    }

    private static List<String> getRotatedTile(List<String> tile) {
        List<String> rotatedTile = new ArrayList<>();
        if (tile.get(0).length() != tile.get(1).length()) {
            String tileID = tile.get(0);
            rotatedTile.add(tileID);
            tile.remove(tileID);
        }
        int row = 0;
        while (row < tile.get(0).length()) {
            char[] rotatedRow = new char[tile.size()];
            int j = 0;
            for (int i = tile.size() - 1; i >= 0; i--)
                rotatedRow[j++] = tile.get(i).toCharArray()[row];
            rotatedTile.add(String.valueOf(rotatedRow));
            row += 1;
        }
        return rotatedTile;
    }

    private static List<String> getAllBordersOfTile(List<String> tile) {
        List<String> allBorders = new ArrayList<>();
        allBorders.addAll(getHorizontalBorders(tile));
        allBorders.addAll(getVerticalBorders(tile));
        return allBorders;
    }

    private static List<String> getVerticalBorders(List<String> tile) {
        List<String> frontAndBackBorders = new ArrayList<>();
        char[] frontBorder = new char[tile.size() - 1];
        char[] backBorder = new char[tile.size() - 1];
        for (int i = 1; i < tile.size(); i++) {
            String s = tile.get(i);
            frontBorder[i - 1] = (s.toCharArray()[0]);
            backBorder[i - 1] = (s.toCharArray()[s.length() - 1]);
        }
        frontAndBackBorders.add(flipRow(String.valueOf(frontBorder)));
        frontAndBackBorders.add(String.valueOf(backBorder));
        return frontAndBackBorders;
    }

    private static List<String> getHorizontalBorders(List<String> tile) {
        List<String> topAndBottomBorders = new ArrayList<>();
        topAndBottomBorders.add(tile.get(1));
        topAndBottomBorders.add(flipRow(tile.get(tile.size() - 1)));
        return topAndBottomBorders;
    }

    private static String flipRow(String row) {
        return new StringBuilder(row).reverse().toString();
    }

    private static List<List<String>> splitInputToTiles(List<String> input) {
        List<List<String>> tiles = new ArrayList<>();
        List<String> tile = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (s.contains("Tile"))
                s = s.replaceAll("[^0-9]", "");
            if (!s.isEmpty())
                tile.add(s);
            if (s.isEmpty() || i == input.size() - 1) {
                tiles.add(tile);
                tile = new ArrayList<>();
            }
        }
        return tiles;
    }
}